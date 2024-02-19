document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.querySelector('.login_form');
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 기본 제출 동작 방지

        const id = document.getElementById('id').value;
        const password = document.getElementById('password').value;

        //모든 필드가 채워져있는지 확인
        if(!id || !password) {
            alert('모든 필드를 입력해주세요.');
            return;
        }


        //서버로 아이디와 비밀번호를 보내 검증


        //성공시 메인페이지로 리다이렉트
    });
});