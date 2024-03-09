// 글자 바이트 세기
function countUtf8Bytes(str) {
    let byteCount = 0;

    for (let i = 0; i < str.length; i++) {
        const charCode = str.charCodeAt(i);
        //줄바꿈일 경우 바이트2, 아니라면 1
        (charCode==10) ? byteCount+=2: byteCount+=1;
    }

    return byteCount;
}

function countBytes(editor, containerSelector, limit) {
    //toast api일땐 getMarkdown 그냥 input일 경우 value
    const content = editor.getMarkdown ? editor.getMarkdown() : editor.value;
    //문자열을 바이트로 변환
    const byteCount =countUtf8Bytes(content);
    // 글자 수를 표시할 요소에 업데이트
    $(containerSelector).text(byteCount + "/"+limit);

    // 제한을 넘으면 에디터 사용 막기
    if (byteCount > limit) {
        alert('허용된 글자수가 초과되었습니다.')
        const truncatedContent = cutByLen(content, limit);
        editor.setMarkdown ? editor.setMarkdown(truncatedContent,false) : editor.value = truncatedContent; // 넘어간 부분을 잘라냄
    }
}

// 문자열을 주어진 바이트 수에 맞게 자르는 함수
function cutByLen(str, maxByte) {
    for (let b = i = 0; c = str.charCodeAt(i);) {
        //줄 바꿈(/n)일 경우 byte 2, 나머지 1
        b+=c==10?2:1;
        if (b > maxByte) break;
        i++;
    }
    return str.substring(0, i);
}

//제목 글자수 제한
document.querySelector(".title").addEventListener('input', function() {
    countBytes(this, ".title-text-count", titleByteLimit);
});

//제목 글자수 제한
document.querySelector(".writer").addEventListener('input', function() {
    countBytes(this, ".writer-text-count", writerByteLimit);
});

//제목 글자수 제한
document.querySelector(".boardPassword").addEventListener('input', function() {
    countBytes(this, ".boardPassword-text-count", boardPasswordByteLimit);
});