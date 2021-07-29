function fetchAlbumList() {
    let olElement = document.querySelector("ol.album-list");

    let url = "/api/album-list.json";
    let keyword = getParameter("keyword");
    if (keyword) {
        url += `?keyword=${encodeURIComponent(keyword)}`;
    }

    ajax("GET", url, function (result) {
        if (result.success === true) {
            let albumList = result.data;
            for (let album of albumList) {
                let html = `<li class="album-item">
                    <a href="/album.html?aid=${album.aid}">
                        <img src="getPicture/${ album.cover}">
                        <span class="name">${album.name}</span>
                        <span class="count">播放量 ${album.count}</span>
                    </a>
                </li>`
                olElement.innerHTML += html;
            }
        }
    });
}


// 把我们要执行的代码放在 window.load 事件发生后执行，保证代码的执行发生在所有资源都已经加载完成后
window.addEventListener("load", function () {
    // 1. 检查用户登录状态
    checkLogged();
    // 2. 拉取专辑列表并显示
    fetchAlbumList();
});