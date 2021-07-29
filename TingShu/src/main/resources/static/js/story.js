window.addEventListener("load", function () {
    let mainElement = document.querySelector("main");
    let sid = getParameter("sid");
    if (!sid) {
        alert("必须带有 sid");
        return;
    }

    let url = `/api/story-detail.json?sid=${sid}`;
    ajax("GET", url, function (result) {
        if (!result.success) {
            alert(result.reason);
            return;
        }

        let story = result.data;
        mainElement.innerHTML = `
          <h1>${story.name}</h1>
          <span class="createdAt">${story.createdAt}</span>
          <span class="count">${story.count}</span>
          <audio id="voice" controls src="/get-audio?sid=${sid}"></audio>
        `;
        let voice = document.querySelector("#voice");
        voice.addEventListener("play", function () {
            ajax("GET", `/api/story-played.json?sid=${sid}`, function () {
            });
        });
    });
});
