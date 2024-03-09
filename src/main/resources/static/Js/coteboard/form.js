//글자수 제한 길이
const byteLimit = 5000;
const titleByteLimit = 50;
const writerByteLimit = 11;
const boardPasswordByteLimit = 11;

//제목 칸 늘리기
function autoResize(textarea) {
    //height초기화
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight+ 'px';
}

//textarea 실시간 값 변경 감지하기
const titleTextCount=document.querySelector('.title-text-count');
const writerTextCount=document.querySelector('.writer-text-count');
const boardPasswordTextCount=document.querySelector('.boardPassword-text-count');

$(document).ready(function() {
    $('.title').on('change input', function() {
        // Assuming countBytes is a function that you have defined elsewhere
        countBytes(this, titleTextCount, titleByteLimit);
        autoResize(this);
    });
});

//textarea 실시간 값 변경 감지하기
$(document).ready(function() {
    $('.writer').on('change input', function() {
        // Assuming countBytes is a function that you have defined elsewhere
        countBytes(this, writerTextCount, writerByteLimit);
    });
});

//textarea 실시간 값 변경 감지하기
$(document).ready(function() {
    $('.boardPassword').on('change input', function() {
        // Assuming countBytes is a function that you have defined elsewhere
        countBytes(this, boardPasswordTextCount, boardPasswordByteLimit);
    });
});

const submitButton = document.querySelector('.submit-button');
// 등록 버튼 클릭
submitButton.addEventListener('click', () => {
    handleSubmit("/coteboard/form");
});

function handleSubmit(url){
    const title = document.querySelector('.title').value.trim();
    const writer = document.querySelector('.writer').value.trim();
    const boardPassword = document.querySelector('.commentPassword').value.trim();
    const userPassword = document.querySelector('.userPassword').value.trim();
    // 타이틀 또는 quizContent가 비어 있는 경우 알림창을 띄우고 폼을 제출하지 않음
    if (!title || !contentEditor.getMarkdown()) {
        alert('퀴즈 제목과 내용을 작성해주세요.');
        return;
    }
    // 폼 데이터에 새로 생성된 태그 값들을 추가하는 JavaScript 코드 추가
    const formData = new FormData();
    formData.append('contents', contentEditor.getMarkdown());
    formData.append('title', title);
    formData.append('writer', writer);
    formData.append('commentPassword', commentPassword);
    formData.append('userPassword', userPassword);

    // 폼 검증 통과 시
    // 폼 데이터를 서버로 전송
    $.ajax({
        type: 'POST',
        url: url,
        data: formData,
        contentType: false,
        processData: false,
        success: function (redirectUrl) {
            location.href = redirectUrl;
        },
        error: function (error) {
            console.error(error);
        }
    });
}
