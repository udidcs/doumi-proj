document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.querySelector('.login_form');
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // 기본 제출 동작 방지

        const password = document.getElementById('password').value;

        //모든 필드가 채워져있는지 확인
        if(!password) {
            alert('필드를 입력해주세요.');
            return;
        }
        fetch('/coteboard/login', {//url을 어떻게 해야할지?...
          method: 'POST', //HTTP 요청 메서드
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            userPassword: password
          })
        })
        .then(response => response.json())//서버에서 받은 객체를 json으로 변환한다
        .then(data => {
          console.log(data); //로그 출력
          if (data.success) {
            alert(data.message);
            window.location.href = '/';
          } else {
            alert(data.errormsg);
          }
        })
        .catch(error => console.error('Error:', error));

    });
});