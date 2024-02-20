const submitButton = document.querySelector('.submit-button');
// 등록 버튼 클릭
submitButton.addEventListener('click', () => {
    const selectedTags = document.querySelectorAll('.selected-tag');
    const tagValues = Array.from(selectedTags).map(tag => tag.value);
    // 폼 데이터에 새로 생성된 태그 값들을 추가하는 JavaScript 코드 추가
    const formData = new FormData(document.querySelector('.quizForm'));
    formData.append('tags', tagValues.join(','));
    formData.append('quizContent', contentEditor.getMarkdown());
    formData.append('answerContent', answerEditor.getMarkdown());
    // 폼 검증 통과 시
    // 폼 데이터를 서버로 전송
    $.ajax({
        type: 'POST',
        url: '/quiz/post',
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
});
