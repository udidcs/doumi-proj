document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.querySelector('.login_form');
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 기본 제출 동작 방지

        const password = document.getElementById('password').value;

        //모든 필드가 채워져있는지 확인
        if (!password) {
            alert('모든 필드를 입력해주세요.');
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/coteboard/login',
            data: JSON.stringify({
              'userPassword': password
            }),
            contentType: 'application/json',
            processData: false,
            success: function (redirectUrl) {
              location.href = redirectUrl;
            },
            error: function (error) {
              console.error(error);
            }
        });
    });
});