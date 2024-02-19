const editor = new toastui.Editor({
    el: document.querySelector('.quiz-content'), // 에디터를 적용할 요소 (컨테이너)
    height: '700px',                        // 에디터 영역의 높이 값 (OOOpx || auto)
    initialEditType: 'markdown',            // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
    initialValue: '',                       // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
    previewStyle: 'vertical',               // 마크다운 프리뷰 스타일 (tab || vertical)
    placeholder: '퀴즈 문제를 내주세요.',
    events: {
        change: function () {
            console.log(editor.getMarkdown());
        }
    },
});
const editor2 = new toastui.Editor({
    el: document.querySelector('.answer-content'), // 에디터를 적용할 요소 (컨테이너)
    height: '500px',                        // 에디터 영역의 높이 값 (OOOpx || auto)
    initialEditType: 'markdown',            // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
    initialValue: '',                       // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
    previewStyle: 'vertical',               // 마크다운 프리뷰 스타일 (tab || vertical)
    placeholder: '정답을 적어주세요.',
});

// 등록 버튼 클릭
submitButton.addEventListener('click', () => {
    const selectedTags = document.querySelectorAll('.selected-tag');
    const tagValues = Array.from(selectedTags).map(tag => tag.value);
    // 폼 데이터에 새로 생성된 태그 값들을 추가하는 JavaScript 코드 추가
    const formData = new FormData(document.querySelector('.quizForm'));
    formData.append('tags', tagValues.join(','));
    formData.append('quizContent', editor.getMarkdown());
    formData.append('answerContent',editor2.getMarkdown());
    // 폼 검증 통과 시
    // 폼 데이터를 서버로 전송
    $.ajax({
        type: 'POST',
        url: '/quiz/post',
        data: formData,
        contentType: false,
        processData: false,
        success: function (html){
            location.href="/quiz/";
        },
        error: function(error) {
            console.error(error);
        }
    });
});

function autoResize(textarea) {
    //height초기화
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight+ 'px';
}