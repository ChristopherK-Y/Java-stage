window.addEventListener("load", function () {
    let logged = checkLogged();
    if (logged === false) {
        alert("必须先进行登录");
        window.location = "/login.html";
    }
});