"use strict";

const log = (function () {
    function f(n) {
        if (n >= 0 && n < 10) {
            return `0${n}`;
        } else {
            return n;
        }
    }

    Date.prototype.format = function () {
        return `${this.getFullYear()}-${f(this.getMonth() + 1)}-${f(this.getDate())} ${f(this.getHours())}:${f(this.getMinutes())}:${f(this.getSeconds())}`
    }

    const logPre = document.querySelector("pre");
    return function (message) {
        let now = new Date().format();
        logPre.innerText += `[${now}] ${message}\r\n`;
        logPre.scrollTo(0, logPre.scrollHeight);
    }
})();

const global = {}

function checkLoggedForNewStory() {
    ajax("GET", "/api/current-user.json", function (result) {
        if (result.logged === false) {
            alert("必须先进行登陆，即将跳转至登陆页面")
            window.location = "/login.html"
        }
    });
}

function checkAid() {
    let aid = getParameter("aid");
    if (!aid) {
        alert("页面必须携带 aid,即将跳转至专辑页面");
        window.location = "/my-album-list.html";
        return;
    }

    global.aid = aid;
}

function initGlobalVariables() {
    log("全局变量定义中")

    global.main = document.querySelector("main");
    global.canvas = document.querySelector("canvas");
    global.canvasCtx = canvas.getContext("2d");

    global.audio = document.querySelector("audio");

    global.authorizeBtn = document.querySelector("#authorize");
    global.startBtn = document.querySelector("#start");
    global.stopBtn = document.querySelector("#stop");
    global.uploadBtn = document.querySelector("#upload");

    global.stream = null;
    global.mediaRecorder = null;
    global.chunks = [];
    global.audioBlob = null;

    global.input = document.querySelector("input");
    global.form = document.querySelector("form");
}

function initCanvas() {
    // 设置宽度
    global.canvas.width = global.main.offsetWidth;
    const WIDTH = global.canvas.width;
    const HEIGHT = global.canvas.height;

    // 设置背景色
    global.canvasCtx.fillStyle = 'rgb(200, 200, 200)';
    global.canvasCtx.fillRect(0, 0, WIDTH, HEIGHT);

    // 画中间的线
    global.canvasCtx.lineWidth = 2;
    global.canvasCtx.strokeStyle = 'rgb(0, 0, 0)';

    global.canvasCtx.beginPath();
    global.canvasCtx.moveTo(0, HEIGHT / 2.0);
    global.canvasCtx.lineTo(WIDTH, HEIGHT / 2.0);
    global.canvasCtx.stroke();
}

function initial() {
    log("进行初始化工作")
    initCanvas();
}

function visualize(stream) {
    const audioCtx = new AudioContext();
    const source = audioCtx.createMediaStreamSource(stream);
    const analyser = audioCtx.createAnalyser();
    analyser.fftSize = 2048;
    const bufferLength = analyser.frequencyBinCount;
    const dataArray = new Uint8Array(bufferLength);

    source.connect(analyser);

    draw();

    function draw() {
        const WIDTH = global.canvas.width;
        const HEIGHT = global.canvas.height;
        const ctx = global.canvasCtx;

        // 利用该函数，保证 draw 函数 会在下次浏览器进行绘制时也被调用
        requestAnimationFrame(draw);

        // 获取声音的时域数据（就是波形数据）
        analyser.getByteTimeDomainData(dataArray);

        ctx.fillStyle = 'rgb(200, 200, 200)';
        ctx.fillRect(0, 0, WIDTH, HEIGHT);

        ctx.lineWidth = 2;
        ctx.strokeStyle = 'rgb(0, 0, 0)';

        ctx.beginPath();
        let sliceWidth = WIDTH * 1.0 / bufferLength;
        let x = 0;

        for (let i = 0; i < bufferLength; i++) {
            let v = dataArray[i] / 128.0;
            let y = v * HEIGHT / 2;

            if (i === 0) {
                ctx.moveTo(x, y);
            } else {
                ctx.lineTo(x, y);
            }

            x += sliceWidth;
        }

        ctx.lineTo(canvas.width, canvas.height / 2);
        ctx.stroke();
    }
}

function mediaRecorderStop() {
    log("停止录制")

    log("生成声音对象")
    global.audioBlob = new Blob(global.chunks, {'type': 'audio/ogg; codecs=opus'})
    global.chunks = [];

    log("生成预览声音");
    let audioURL = window.URL.createObjectURL(global.audioBlob);
    global.audio.src = audioURL;

    log("开启下一阶段按钮可用性")
    global.stopBtn.disabled = true
    global.uploadBtn.disabled = false
}

function mediaRecorderDataAvailable(e) {
    log("一次数据已到位，记录")
    global.chunks.push(e.data);
}

function authorize() {
    log("请求用户授权麦克风使用权限")
    navigator.mediaDevices.getUserMedia({
        audio: true
    })
        .then(function (stream) {
            log("用户同意了授权")
            global.stream = stream;
            global.mediaRecorder = new MediaRecorder(stream);
            log("进行声音波形绘制")
            visualize(stream);

            log("实例化声音录制器对象")
            global.mediaRecorder.onstop = mediaRecorderStop;
            global.mediaRecorder.ondataavailable = mediaRecorderDataAvailable;

            log("开启下一阶段按钮可用性")
            global.authorizeBtn.disabled = true
            global.startBtn.disabled = false
        })
        .catch(function (error) {
            log("授权出错: " + error)
        });
}

function start() {
    log("开始声音录制")
    log("每 1000 毫秒一次记录")
    global.mediaRecorder.start(1000);
    log("开启下一阶段按钮可用性")
    global.startBtn.disabled = true
    global.stopBtn.disabled = false
}

function stop() {
    global.mediaRecorder.stop();
}

function upload() {
    log("开始进行上传")
    if (!global.input.value) {
        alert("故事名称是必须填写的")
        return;
    }
    let formData = new FormData(global.form);
    formData.append("aid", global.aid);
    formData.append("audio", global.audioBlob);

    var xhr = new XMLHttpRequest();
    xhr.open(global.form.method, global.form.action);
    xhr.onload = function () {
        let result = JSON.parse(xhr.responseText);
        if (!result.success) {
            alert("错误" + result.reason)
        } else {
            window.location = `/album-editor.html?aid=${global.aid}`
        }
    }
    xhr.send(formData);
}

function bindEventListeners() {
    log("进行事件绑定");
    global.authorizeBtn.addEventListener("click", authorize);
    global.startBtn.addEventListener("click", start);
    global.stopBtn.addEventListener("click", stop);
    global.uploadBtn.addEventListener("click", upload);
}

function main() {
    checkLoggedForNewStory();

    // 检查必要的参数是否存在 aid
    checkAid();

    // 初始化全局变量
    initGlobalVariables();

    // 执行其他初始化操作
    initial();

    // 进行事件处理绑定操作
    bindEventListeners();
}

window.addEventListener("load", main);