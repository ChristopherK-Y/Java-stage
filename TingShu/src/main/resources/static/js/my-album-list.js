window.addEventListener("load", function () {
    let olElement = document.querySelector("ol");

    let logged = checkLogged();
    if (logged === false) {
        alert("请登陆，即将跳转至登陆页");
        window.location = "/login.html";
        return;
    }

    ajax("GET", "/api/my-album-list.json", function (result) {
        if (result.success === false) {
            alert("获取资源失败\n原因为:\n" + result.reason);
            window.location = "/login.html"
            return;
        }
        let albumList = result.data;
        for (let album of albumList) {
            let html = `<li class="album-item">
                            <a href="/album-editor.html?aid=${album.aid}">
                                <h2>${album.name}</h2>
                                <img src="getPicture/${album.cover}" alt="cover">
                                <p>${album.count}</p>
                                <p>${album.createdAt}</p>
                            </a>
                        </li>`
            olElement.innerHTML += html;
        }
    });
});