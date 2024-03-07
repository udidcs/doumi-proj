// 대댓글 숨기기 기능
const hideButton = document.querySelectorAll('.re-comment-display-control');

function updateHideButton(reCommentItemsContainer, button) {
    //대댓글 div안에 있는 댓글들
    const recommentItems = reCommentItemsContainer.querySelectorAll('.re-comment-item-container');
    let count = recommentItems.length;

    if (reCommentItemsContainer.classList.contains('hidden')) {
        button.innerHTML = count + "개 답변";
    } else {
        button.innerHTML = `<img src="/images/icon_up_arrow.png" alt="숨기기 버튼"> 숨기기`;
    }
}


hideButton.forEach((button) => {
    button.addEventListener('click', () => {
        //closest 메서드를 사용하여 각 버튼에 가장 가까운 .comment-item-container를 찾고, 해당 컨테이너 내부에서 .re-comment-items-container를 선택
        const reCommentItemsContainer = button.closest('.comment-item-container').querySelector('.re-comment-items-container');
        //대댓글이 하나도 없을 수도 있다.
        // 대댓글 div hidden
        reCommentItemsContainer.classList.toggle("hidden");
        updateHideButton(reCommentItemsContainer, button);

    });
});



// 대댓글 숨기기 기능
function updateHideButton(reCommentItemsContainer, button) {
    //대댓글 div안에 있는 댓글들
    const recommentItems = reCommentItemsContainer.querySelectorAll('.re-comment-item-container');
    let count = recommentItems.length;

    if (reCommentItemsContainer.classList.contains('hidden')) {
        button.innerHTML = count + "개 답변";
    } else {
        button.innerHTML = `<img src="/images/icon_up_arrow.png" alt="숨기기 버튼"> 숨기기`;
    }
}


//대댓글 작성
function clickReCommentEditorOpener(button){
    let commentContainer = button.closest('.comment-item-container');
    const reCommentEditor = commentContainer.querySelector('.re-comment-editor');
    reCommentEditor.classList.toggle('hidden');
}

//대대댓글 작성
function clickReMoreTwotimesCommentEditorOpener(button){
    let commentContainer = button.closest('.re-comment-item-container');
    const reCommentEditor = commentContainer.querySelector('.re-comment-editor');
    reCommentEditor.classList.toggle('hidden');
}


// 취소 버튼을 누르면 사라진다.
function clickCommentCancel(){
    const commentEditorOpener = document.querySelector('.comment-editor-opener');
    const commentEditor = document.querySelector('.comment-editor');
    commentEditorOpener.classList.toggle('hidden');
    commentEditor.classList.toggle('hidden');
}

//대댓글 취소 버튼 사라짐
function clickReCommentCancel(button){
    const reCommentEditor = button.closest('.re-comment-editor');
    reCommentEditor.classList.toggle('hidden');
}
