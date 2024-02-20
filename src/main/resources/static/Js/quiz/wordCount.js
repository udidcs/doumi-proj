//글자수 제한 길이
const byteLimit = 2000;
const titleByteLimit = 250;

// 글자 바이트 세기
function countBytes(editor, containerSelector, limit) {
    //toast api일땐 getMarkdown 그냥 input일 경우 value
    const content = editor.getMarkdown ? editor.getMarkdown() : editor.value;
    const encoder = new TextEncoder("utf-8");
    //문자열을 utf-8바이트로 변환
    const byteCount = encoder.encode(content).length;

    // 글자 수를 표시할 요소에 업데이트
    $(containerSelector).text(byteCount + "/"+limit);

    // 제한을 넘으면 에디터 사용 막기
    if (byteCount > limit) {
        alert('허용된 글자수가 초과되었습니다.')
        const truncatedContent = cutByLen(content, limit);
        editor.setMarkdown ? editor.setMarkdown(truncatedContent) : editor.value = truncatedContent; // 넘어간 부분을 잘라냄
    }
}

// 문자열을 주어진 바이트 수에 맞게 자르는 함수
function cutByLen(str, maxByte) {
    for (let b = i = 0; c = str.charCodeAt(i);) {
        //유니코드를 128로 나눴을때 1이면 한글(3바이트), 0이면 1바이트로 표현됨
        b += c >> 7 ? 3 : 1;
        if (b > maxByte) break;
        i++;
    }
    return str.substring(0, i);
}

//제목 글자수 제한
document.querySelector(".title").addEventListener('input', function() {
    countBytes(this, ".title-text-count", titleByteLimit);
});


// 초기화시 글자 수 업데이트
countBytes(contentEditor, ".quiz-text-count", byteLimit);
countBytes(answerEditor, ".answer-text-count", byteLimit);
countBytes(document.querySelector('.title'), ".title-text-count", titleByteLimit);