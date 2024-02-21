const contentEditor = new toastui.Editor({
    el: document.querySelector('.quiz-content'), // 에디터를 적용할 요소 (컨테이너)
    height: '700px',                        // 에디터 영역의 높이 값 (OOOpx || auto)
    initialEditType: 'markdown',            // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
    initialValue: quizContent,                       // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
    previewStyle: 'vertical',               // 마크다운 프리뷰 스타일 (tab || vertical)
    placeholder: '퀴즈 문제를 내주세요.',
    events: {
        change: function () {
            //wordCount.js 파일
            countBytes(contentEditor, ".quiz-text-count", byteLimit);
        }
    },
});

const answerEditor = new toastui.Editor({
    el: document.querySelector('.answer-content'), // 에디터를 적용할 요소 (컨테이너)
    height: '500px',                        // 에디터 영역의 높이 값 (OOOpx || auto)
    initialEditType: 'markdown',            // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
    initialValue: answerContent,                       // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
    previewStyle: 'vertical',               // 마크다운 프리뷰 스타일 (tab || vertical)
    placeholder: '정답을 적어주세요.',
    events: {
        change: function () {
            countBytes(answerEditor, ".answer-text-count", byteLimit);
        }
    },
});