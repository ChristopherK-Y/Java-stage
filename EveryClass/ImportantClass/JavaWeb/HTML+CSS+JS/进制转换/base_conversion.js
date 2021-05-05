let transformButton = document.querySelector("button");
transformButton.addEventListener("click", function () {
    let selArray = document.getElementsByName("sel");
    let inputBase = "";
    for (let i = 0; i < selArray.length; i++) {
        if (selArray[i].checked) {
            inputBase = selArray[i].id;
            //console.log(inputBase);
        }
    }
    if (inputBase === "") {
        alert("请选择输入进制");
    } else {
        let out2 = document.querySelector("#out2");
        let out8 = document.querySelector("#out8");
        let out10 = document.querySelector("#out10");
        let out16 = document.querySelector("#out16");

        let inputNumber = document.querySelector("#number").value;
        if(inputNumber === ""){
            alert("请输入要转换的数字！");
        }
        //console.log(inputNumber);
        switch (inputBase) {
            case "two":

            function two() {
                let tenBaseNumber = parseInt(inputNumber, 2);
                //console.log(tenBaseNumber);
                out2.value = tenBaseNumber.toString(2);
                out8.value = tenBaseNumber.toString(8);
                out10.value = tenBaseNumber.toString(10);
                out16.value = tenBaseNumber.toString(16);
            }

                two();
                break;
            case "eight":

            function eight() {
                let tenBaseNumber = parseInt(inputNumber, 8);
                //console.log(tenBaseNumber);
                out2.value = tenBaseNumber.toString(2);
                out8.value = tenBaseNumber.toString(8);
                out10.value = tenBaseNumber.toString(10);
                out16.value = tenBaseNumber.toString(16);
            }

                eight();
                break;
            case "ten":

            function ten() {
                let tenBaseNumber = parseInt(inputNumber, 10);
                //console.log(tenBaseNumber);
                out2.value = tenBaseNumber.toString(2);
                out8.value = tenBaseNumber.toString(8);
                out10.value = tenBaseNumber.toString(10);
                out16.value = tenBaseNumber.toString(16);
            }

                ten();
                break;
            case "sixteen":

            function sixteen() {
                let tenBaseNumber = parseInt(inputNumber, 16);
                //console.log(tenBaseNumber);
                out2.value = tenBaseNumber.toString(2);
                out8.value = tenBaseNumber.toString(8);
                out10.value = tenBaseNumber.toString(10);
                out16.value = tenBaseNumber.toString(16);
            }

                sixteen();
                break;
        }
    }
});