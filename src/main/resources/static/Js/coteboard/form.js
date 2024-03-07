// 취소 버튼 클릭
const cancelButton = document.querySelector('.cancel-button');
cancelButton.addEventListener('click', () => {
    // 취소
    location.href = '/quiz';
});


//글자수 제한 길이
const byteLimit = 3000;
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