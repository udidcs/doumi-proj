document.addEventListener('DOMContentLoaded', function () {
    const signupForm = document.querySelector('.signup_form');
    signupForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 기본 제출 동작 방지

        const id = document.getElementById('id').value;
        const password = document.getElementById('password').value;
        const passwordConfirm = document.getElementById('passwordConfirm').value;

        // 아이디 유효성 검사
        const idRegex = /^[a-zA-Z0-9]{5,}$/;
        if (!idRegex.test(id)) {
            alert('아이디는 5글자 이상이며 영문자와 숫자만 가능합니다.');
            return;
        }

        // 비밀번호 유효성 검사
        const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
        if (!passwordRegex.test(password)) {
            alert('비밀번호는 최소 8자 이상 최대 20자 이하, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자, 하나의 특수 문자를 포함해야 합니다.');
            return;
        }

        // 비밀번호와 비밀번호 확인 일치 검사
        if (password !== passwordConfirm) {
            alert('비밀번호가 일치하지 않습니다.');
            return;
        }

        // 여기에서 서버로의 폼 제출 로직을 구현할 수 있음
        // 예: fetch()를 사용한 비동기 제출 등

        alert('회원가입이 완료되었습니다.');
    });
});