const byteLimit = 3000;
const titleByteLimit = 250;

//제목 칸 늘리기
function autoResize(textarea) {
    //height초기화
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight+ 'px';
}
window.onload = function() {
    autoResize(document.querySelector('.title'));
};

// 취소 버튼 클릭
const cancelButton = document.querySelector('.cancel-button');
cancelButton.addEventListener('click', () => {
    // 취소
    location.href = '/quiz';
});