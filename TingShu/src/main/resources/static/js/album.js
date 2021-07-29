let meta = document.querySelector(".album-meta");

function updateAlbumMeta(album) {
    meta.innerHTML = `<h1>${album.name}</h1>
  <p>${album.brief}</p>
  <img class="cover" src="getPicture/${album.cover}">
  <img class="header" src="getPicture/${album.header}">
  <div class="createdAt">${album.createdAt}</div>
  <div class="count">播放量 ${album.count}</div>`;
}

let ol = document.querySelector(".story-list");

function appendStory(storyList) {
    for (let story of storyList) {
        ol.innerHTML +=
            `<li>
                <a href="/story.html?sid=${story.sid}">
                  <span class="name">${story.name}</span>
                </a>
                <span class="count">播放量 ${story.count}</span>
                <span class="createdAt">${story.createdAt}</span>
            </li>`;
    }
}

function fetchAlbumDetail() {
    // 1. 从 url 中取出 aid
    let aid = getParameter("aid");
    if (!aid) {
        alert("必须有 aid，否则该页面合法");
        return;
    }

    let url = `/api/album-detail.json?aid=${aid}`;
    ajax("GET", url, function (result) {
        if (!result.success) {
            alert(result.reason);
            return;
        }

        let album = result.data;

        updateAlbumMeta(album);
        appendStory(album.storyList);
    });
}

window.addEventListener("load", function () {
    // 1. 拉取用户在线情况
    checkLogged();
    // 2. 拉取当前专辑的详情
    fetchAlbumDetail();
});