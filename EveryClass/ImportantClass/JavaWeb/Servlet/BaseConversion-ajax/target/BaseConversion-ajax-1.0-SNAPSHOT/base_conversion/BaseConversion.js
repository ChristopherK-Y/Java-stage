

document.querySelector("button").addEventListener("click", function () {
    let request = new XMLHttpRequest();
    request.open("post", "/Ajax-Version",true);

    request.addEventListener("load", function () {
        let lines = this.responseText.split('\n');
        document.querySelector("#out2").value = lines[0];
        document.querySelector("#out8").value = lines[1];
        document.querySelector("#out10").value = lines[2];
        document.querySelector("#out16").value = lines[3];
    });

    let number = document.querySelector("#number").value;
    let elements = document.getElementsByName("sel");
    let fromBase;
    for (let element of elements) {
        if (element.checked === true) {
            fromBase = element.value;
        }
    }
    if (number !== "" && fromBase !== "") {
        let data = number + ":" + fromBase;
        request.send(data);
    }
});
