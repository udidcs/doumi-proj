//대댓글 작성
function clickReCommentEditorOpener(button){
    button.classList.toggle('hidden');
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
    button.closest('.re-comment-editor').classList.toggle('hidden');
    button.closest('.re-comment-editor').previousElementSibling.firstElementChild.firstElementChild.classList.toggle('hidden');
    button.parentElement.previousElementSibling.previousElementSibling.value='';
}

function clickUpdateReCommentCancel(button){
    button.parentElement.classList.toggle('hidden')
    button.parentElement.previousElementSibling.firstElementChild.classList.toggle('re-comment-item');
    button.parentElement.previousElementSibling.previousElementSibling.lastElementChild.classList.toggle('hidden');
}




function switchEditCommentForm(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "0.15";
    document.querySelector(".modal_recomment_update").style.display= "flex";
    button.parentNode.parentNode.nextElementSibling.firstElementChild.classList.toggle('comment-item');

    // comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideContㅇㄷrol(commentItemContainer);
}
function switchEditReCommentForm(button){
    // 클릭한 버튼과 가장 가까운 re-comment-container 찾기 (버튼 누른 대댓글 영역 찾기)
        button.parentNode.classList.toggle('hidden');
        button.parentNode.parentNode.nextElementSibling.firstElementChild.classList.toggle('re-comment-item');
        button.parentNode.parentNode.nextElementSibling.nextElementSibling.classList.toggle('hidden');

}

//서버로 보낼 데이터 정제
//function getCommentData(commentItemContainer, type) {
//    const postId = document.querySelector('.postId').value;
//    //a 속성에는 value 속성이 적용 되지 않아 getAttribute로 가져왔다.
//    const userId = commentItemContainer.querySelector('.comment-writer-name').getAttribute('value');
//
//    let commentContent;
//    let parentCommentId;
//
//    if(type==="comment"){
//        parentCommentId=0;
//        commentContent=commentItemContainer.querySelector('.comment-item');
//    }else{
//        parentCommentId=1;
//        commentContent=commentItemContainer.querySelector('.comment-item-body');
//    }
//
//    const contents = commentContent.textContent;
//    const display = commentContent.classList.contains('hide-text');
//
//    return {
//        userId: userId,
//        postId: postId,
//        contents: contents,
//        parentCommentId: parentCommentId,
//        display: display,
//    };
//}

//취소 버튼을 누르면 원래 댓글 형태로 돌아간다.
function clickCommentEditCancelButton(button){
    //부모 요소중 .re-comment-item-container를 찾고, 없을 경우 .comment-item-container를 찾는다.
    //recomment인지 comment인지 구별 필요
    const commentItemContainer = button.closest('.re-comment-item-container') || button.closest('.comment-item-container');

    editButtonHideControl(commentItemContainer);

    let data;
    if(commentItemContainer.classList.contains('re-comment-item-container')){
        data=createCommentItemBody(commentItemContainer,"reComment");
    }else{
        data=createCommentItemBody(commentItemContainer,"comment");
    }

    $(commentItemContainer).children('.comment-form').replaceWith(data);
}

//댓글 div 생성
function createCommentItemBody(commentItemContainer, type){
    //comment-item-body div 생성
    const commentItemBody= document.createElement('div');
    commentItemBody.classList.add('comment-item-body');

    //댓글 contents 가져오기
    const textContent=commentItemContainer.querySelector('.answer-input').textContent;

    if(type==="comment"){
        //댓글에 경우 체크박스가 있다.
        const checked= commentItemContainer.querySelector('.display-check').checked;

        //comment-item div 생성
        const commentItem= document.createElement('div');
        commentItem.classList.add('comment-item');

        //체크박스 여부로 비공개, 공개 상태 변경
        if (checked){
            commentItemBody.classList.add('hide-place');
            commentItem.classList.add('hide-text');

            commentItemBody.onclick= function() {
                clickComment(commentItemBody);
            };
        }

        commentItem.textContent=textContent;
        commentItemBody.append(commentItem);

    }else{
        //대댓글일 때는 그냥 content만 body에 넣어주면 된다.
        commentItemBody.textContent=textContent;
    }

    return commentItemBody;
}


//수정, 삭제 버튼 사라지게 함
function editButtonHideControl(commentItemContainer){
    const commentEditContainer= commentItemContainer.querySelector('.comment-edit-container');
    commentEditContainer.classList.toggle('hidden');
}
