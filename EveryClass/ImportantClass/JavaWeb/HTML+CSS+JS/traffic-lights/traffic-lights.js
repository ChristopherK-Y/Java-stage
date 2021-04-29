/*
setTimeout(function () {
  // 5 秒后会执行这个函数，但是只会执行一次
  alert("5s 已到");
}, 5000);
 */

/*
setInterval(function () {
  // 5 秒后会执行这个函数，并且以后每 5s 执行一次
  alert("5s 已到");
}, 5000);
 */

var redDuration = 4;
var yellowDuration = 2;
var greenDuration = 5;


var redLight = document.querySelector("#red");
var yellowLight = document.querySelector("#yellow");
var greenLight = document.querySelector("#green");

var onLight;
var timeout;

// 灯暗不显示，灯亮显示倒计时
function init() {
  greenLight.innerText = greenDuration;
  onLight = greenLight;
  timeout = greenDuration;
}

init();

setInterval(function () {
  timeout--;
  onLight.innerText = "";
  if (timeout == 0) {
    if (onLight == greenLight) {
      onLight = yellowLight;
      timeout = yellowDuration;
      greenLight.classList.remove("green-on");
      greenLight.classList.add('green-off');

      yellowLight.classList.remove("yellow-off");
      yellowLight.classList.add("yellow-on");
    } else if (onLight == yellowLight) {
      onLight = redLight;
      timeout = redDuration;

      yellowLight.classList.remove("yellow-on");
      yellowLight.classList.add("yellow-off");

      redLight.classList.remove("red-off");
      redLight.classList.add("red-on");
    } else {
      onLight = greenLight;
      onLight = greenLight;
      timeout = greenDuration;

      redLight.classList.remove("red-on");
      redLight.classList.add("red-off");

      greenLight.classList.remove("green-off");
      greenLight.classList.add('green-on');
    }
  }

  onLight.innerText = timeout;
}, 1000);