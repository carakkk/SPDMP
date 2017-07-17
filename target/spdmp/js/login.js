/**
 * Created by HouRuidong on 2016/8/26.
 */
$(function () {
    init();

});
function init() {
    $('#loginInputUsername').val(localStorage.username);
    window.onload = function () {
        $('#loginInputPassword').val("");
    };
    bindEvent();
}
document.onkeydown = function (e) {
    var theEvent = window.event || e;
    var code = theEvent.keyCode || theEvent.which;
    if (code == 13) {
        $('#loginBtn').click();
    }
};

function bindEvent() {
    $('#loginInputUsername').focus( function () {
        $('#usernameImage').attr('src', './images/login/user-blue.png')
    }).blur( function () {
        $('#usernameImage').attr('src', './images/login/user-gray.png')
    });

    $('#loginInputPassword').focus( function () {
        $('#passwordImage').attr('src', './images/login/password-blue.png')
    }).blur(function () {
        $('#passwordImage').attr('src', './images/login/password-gray.png')
    });

    $('#loginBtn').on('click', login);
}

function login() {
    var reqJson = {
        username: $('#loginInputUsername').val().trim(),
        password: $('#loginInputPassword').val().trim()
    };
    if (validateFormArgs(reqJson)){
        $.ajax({
            method: "POST",
            url: "/spdmp/login",
            data: JSON.stringify(reqJson),
            contentType: "application/json;charset=utf-8",
            cache: false,
            success: dealLoginMsg,
            error: function () {
                alert("未连接至服务器，请联系管理员！");
            }
        });
    }
}

function validateFormArgs(formData) {
    if (formData.username == '') {
        $('#loginMsg').html('用户名不能为空');
        return false;
    } else if (formData.password == '') {
        $('#loginMsg').html('密码不能为空');
        return false
    }
    return true;
}

function dealLoginMsg(data) {
    if (data.code == 1) {
        localStorage.authority = data.data.authority;
        localStorage.username = $('#loginInputUsername').val().trim();
        window.location.assign('index.html');
    } else {
        $('#loginMsg').html(data.msg);
    }
}