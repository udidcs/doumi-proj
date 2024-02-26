function commentWordCount(textarea){
    const commentTextCount = document.querySelector('.comment-text-count');
    countBytes(textarea, commentTextCount, 1500);
}

function reCommentWordCount(textarea){
    const reCommentForm= textarea.closest('.re-comment-form');
    const reCommentTextCount = reCommentForm.querySelector('.re-comment-text-count');
    countBytes(textarea, reCommentTextCount, 1500);
}