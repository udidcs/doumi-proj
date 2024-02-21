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
    hooks: {
        addImageBlobHook: (blob, callback) => {

            const formData = new FormData();
            formData.append('file', blob);

            let url = 'http://localhost:8080/images/quiz/';

            $.ajax({
                type: 'POST',
                enctype: 'multipart/form-data',
                url: '/board/file',
                data: formData,
                dataType: 'json',
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {

                    console.log('ajax 이미지 업로드 성공');
                    console.log(data);
                    //url += data.fileName;
                    callback(url, '사진 대체 텍스트 입력');
                },
                error: function (e) {
                    console.log('ajax 이미지 업로드 실패');

                    callback('image_load_fail', '사진 대체 텍스트 입력');
                }
            });
        }
    }
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
        url: 'quiz/post',
        data: formData,
        contentType: false,
        processData: false,
        success: function (postId){
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
