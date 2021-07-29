window.addEventListener("load", function () {
    let h1Element = document.querySelector("h1");
    let aElement = document.querySelector("a");
    let olElement = document.querySelector("ol");

    let aid = getParameter("aid");
    if (!aid) {
        alert("参数 aid 是必须的");
        return;
    }

    ajax("GET", `/api/edit-album-detail.json?aid=${aid}`, function (result) {
        if (result.success === false) {
            alert("发生错误:" + result.reason);
            return;
        }

        let album = result.data;
        h1Element.innerText = `${album.name}`;
        aElement.href = `/new-story.html?aid=${album.aid}`;
        for (let story of album.storyList) {
            olElement.innerHTML += `<li>${story.name}</li>`
        }
    });
});