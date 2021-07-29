function ajax(method, url, onLoadFun) {
    let xhr = new XMLHttpRequest();
    xhr.open(method, url, onLoadFun);
    xhr.addEventListener("load", function () {
        let result = JSON.parse(xhr.responseText);
        onLoadFun(result);
    });
    xhr.send();
}

function getParameter(name) {
    let query = window.location.search.substring(1);
    let params = query.split("&");
    for (let param of params) {
        let pair = param.split("=");
        if (pair[0] === name) {
            return decodeURIComponent(pair[1]);
        }
    }
    return undefined;
}

function checkLogged() {
    let userElement = document.querySelector(".user");
    let flag;
    ajax("GET", "/api/current-user.json", function (result) {
        if (result.logged === true) {
            let currentUser = result.user;
            // 用户已经登录
            let html = `<a href="/new-album.html">新建专辑</a>
                  <a href="/my-album-list.html">我的专辑</a>
                  <span>${currentUser.nickname}</span>`;
            userElement.innerHTML = html;
            flag = true;
        } else {
            flag = false;
        }
    });
    return flag;
}