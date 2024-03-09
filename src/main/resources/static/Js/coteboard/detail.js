// 댓글 등록 관련 변수
let comment_content;
let comment_postid;
// 댓글 등록
function clickCommentSubmitButton(button){
    comment_content = button.parentNode.previousElementSibling.previousElementSibling.value;
    comment_postid = button.parentNode.previousElementSibling.previousElementSibling.previousElementSibling.value;
    document.querySelector("main").style.opacity= "0.2";
    document.querySelector(".modal_comment_create").style.display= "flex";
}

// 댓글 등록 완료
function clickCommentSubmitCompleteButton(button){
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_comment_create").style.display= "none";
    let writer = button.closest('.modal_comment_create').querySelector('.writer').value;
    button.closest('.modal_comment_create').querySelector('.writer').value = '';
    let commentPassword = button.closest('.modal_comment_create').querySelector('.commentPassword').value;
    button.closest('.modal_comment_create').querySelector('.commentPassword').value = '';
    submitCommentForm({'writer': writer, 'commentPassword': commentPassword});
}

// 댓글 등록 취소
function clickCommentSubmitCancelButton(button){
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_comment_create").style.display= "none";
//    const commentForm=button.closest('.comment-form');
//    submitCommentForm(commentForm);
}

// 댓글 수정
function clickCommentEditButton(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "0.2";
    document.querySelector(".modal_comment_edit").style.display= "flex";
//    button.parentNode.parentNode.nextElementSibling.firstElementChild.classList.toggle('comment-item');

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}


// 댓글 수정 로그인
function clickCommentEditLoginButton(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_comment_edit").style.display= "none";
//    button.parentNode.parentNode.nextElementSibling.firstElementChild.classList.toggle('comment-item');

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}


// 댓글 수정 취소
function clickCommentEditCancelButton(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_comment_edit").style.display= "none";
//    button.parentNode.parentNode.nextElementSibling.firstElementChild.classList.toggle('comment-item');

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}

// 댓글 삭제
function clickCommentDeleteButton(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "0.2";
    document.querySelector(".modal_comment_delete").style.display= "flex";

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}

// 댓글 삭제 로그인
function clickCommentDeleteLoginButton(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_comment_delete").style.display= "none";

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}

// 댓글 삭제 취소
function clickCommentDeleteCancelButton(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_comment_delete").style.display= "none";

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}




// 대댓글 등록 관련 변수
let recomment_content;
let recomment_postid;
let recomment_parentid;

// 대댓글 클릭
function clickReCommentEditorOpener(button){

    button.classList.toggle('hidden');
    let commentContainer = button.closest('.comment-item-container');
    const reCommentEditor = commentContainer.querySelector('.re-comment-editor');
    reCommentEditor.classList.toggle('hidden');
}

// 대댓글 등록
function clickReCommentSubmitButton(button){
    recomment_content = button.parentNode.previousElementSibling.previousElementSibling.value;
    console.log(document.getElementById('postId'))
    recomment_postid = document.getElementById('postId').value;
    recomment_parentid = button.closest('.re-comment-form').firstElementChild.value;
    document.querySelector("main").style.opacity= "0.2";
    document.querySelector(".modal_recomment_create").style.display= "flex";
}

// 대댓글 등록 완료
function clickReCommentSubmitCompleteButton(button){
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_recomment_create").style.display= "none";
    let writer = button.closest('.modal_recomment_create').querySelector('.writer').value;
    button.closest('.modal_recomment_create').querySelector('.writer').value = '';
    let recommentPassword = button.closest('.modal_recomment_create').querySelector('.recommentPassword').value;
    button.closest('.modal_recomment_create').querySelector('.recommentPassword').value = '';
    submitReCommentForm({'writer': writer, 'recommentPassword': recommentPassword});
}

// 대댓글 등록 취소
function clickReCommentSubmitCancel(button){
    button.closest('.re-comment-editor').classList.toggle('hidden');
    button.closest('.re-comment-editor').previousElementSibling.firstElementChild.firstElementChild.classList.toggle('hidden');
    button.parentElement.previousElementSibling.previousElementSibling.value='';
}

// 대댓글 취소
function clickReCommentCancel(button) {
    // 클릭한 버튼과 가장 가까운 comment-container 찾기 (버튼 누른 댓글 영역 찾기)
    button.closest('.re-comment-editor').classList.toggle('hidden');
    button.closest('.re-comment-editor').previousElementSibling.firstElementChild.firstElementChild.classList.toggle('hidden');
//    button.parentNode.parentNode.nextElementSibling.firstElementChild.classList.toggle('comment-item');

// comment/ajaxCreatUpdateRequest.js
//    requestEditCommentForm(commentItemContainer, comment);
//    editButtonHideControl(commentItemContainer);
}


// 대댓글 수정
function clickReCommentEditButton(button){
    document.querySelector("main").style.opacity= "0.2";
    document.querySelector(".modal_recomment_edit").style.display= "flex";

}

// 대댓글 수정 로그인
function clickReCommentSubmitEditLoginButton(button){
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_recomment_edit").style.display= "none";

}

// 대댓글 수정 취소
function clickReCommentSubmitEditCancelButton(button){
    document.querySelector("main").style.opacity= "1";
    document.querySelector(".modal_recomment_edit").style.display= "none";

}

function submitCommentForm(json_obj) {
    console.log(json_obj);
    const formData = new FormData();
    formData.append('contents', comment_content);
    formData.append('postId', comment_postid);
    formData.append('writer', json_obj['writer']);
    formData.append('commentPassword', json_obj['commentPassword']);
    formData.append('parentCommentId', 0);

    $.ajax({
        url: '/comment/save',
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (data) {
            $('.comment-container').html(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function submitReCommentForm(json_obj) {
    console.log(json_obj);
    const formData = new FormData();
    formData.append('contents', recomment_content);
    formData.append('postId', recomment_postid);
    formData.append('writer', json_obj['writer']);
    formData.append('commentPassword', json_obj['recommentPassword']);
    formData.append('parentCommentId', recomment_parentid);

    $.ajax({
        url: '/comment/save',
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (data) {
            $('.comment-container').html(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

















//
//
//
//
//
//
//function clickUpdateReCommentCancel(button){
//    button.parentElement.classList.toggle('hidden')
//    button.parentElement.previousElementSibling.firstElementChild.classList.toggle('re-comment-item');
//    button.parentElement.previousElementSibling.previousElementSibling.lastElementChild.classList.toggle('hidden');
//}




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


//댓글 div 생성
//function createCommentItemBody(commentItemContainer, type){
//    //comment-item-body div 생성
//    const commentItemBody= document.createElement('div');
//    commentItemBody.classList.add('comment-item-body');
//
//    //댓글 contents 가져오기
//    const textContent=commentItemContainer.querySelector('.answer-input').textContent;
//
//    if(type==="comment"){
//        //댓글에 경우 체크박스가 있다.
//        const checked= commentItemContainer.querySelector('.display-check').checked;
//
//        //comment-item div 생성
//        const commentItem= document.createElement('div');
//        commentItem.classList.add('comment-item');
//
//        //체크박스 여부로 비공개, 공개 상태 변경
//        if (checked){
//            commentItemBody.classList.add('hide-place');
//            commentItem.classList.add('hide-text');
//
//            commentItemBody.onclick= function() {
//                clickComment(commentItemBody);
//            };
//        }
//
//        commentItem.textContent=textContent;
//        commentItemBody.append(commentItem);
//
//    }else{
//        //대댓글일 때는 그냥 content만 body에 넣어주면 된다.
//        commentItemBody.textContent=textContent;
//    }
//
//    return commentItemBody;
//}


//수정, 삭제 버튼 사라지게 함
//function editButtonHideControl(commentItemContainer){
//    const commentEditContainer= commentItemContainer.querySelector('.comment-edit-container');
//    commentEditContainer.classList.toggle('hidden');
//}




//삭제 버튼
//function  clickDeleteButton(button){
//    document.querySelector("main").style.opacity= "0.15";
//    document.querySelector(".modal_recomment_delete").style.display= "flex";
//    const postId = document.querySelector('.post-id').value;
//}
//
//
//
//function requestEditCommentForm(commentItemContainer, comment){
//    $.ajax({
//        url: '/comment/editForm',
//        type: "POST",
//        data: JSON.stringify(comment),
//        processData: false,
//        contentType: 'application/json',
//        success: function (data) {
//            $(commentItemContainer).children('.comment-item-body').replaceWith(data);
//            commentEditFormWordCount(commentItemContainer);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}
//
//function editCommentForm(commentForm,commentId){
//    const formData = new FormData(commentForm);
//    $.ajax({
//        url: "/comment/edit?id="+commentId,
//        type: "POST",
//        data: formData,
//        processData: false,
//        contentType: false,
//        success: function (data) {
//            $('.comment-container').html(data);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}
//
//function deleteComment(postId, commentId){
//    $.ajax({
//        url: "/comment/delete?postId="+postId+"&commentId="+commentId,
//        type: "DELETE",
//        processData: false,
//        contentType: false,
//        success: function (data) {
//            $('.comment-container').html(data);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}
//


//
//
//function clickReCommentSubmitButton(button){
//    const commentForm=button.closest('.re-comment-form');
//    submitCommentForm(commentForm);
//}

//function clickCommentEditButton(button){
//    const commentForm=button.closest('.comment-form');
//    const commentItemContainer= button.closest('.re-comment-item-container') || button.closest('.comment-item-container');
//    const commentId= commentItemContainer.querySelector('.comment-id').value;
//    editCommentForm(commentForm, commentId);
//}

//삭제 버튼
//function  clickDeleteButton(button){
//
//    const confirmed= window.confirm("정말 삭제하시겠습니까?");
//
//    if(confirmed) {
//        const postId = document.querySelector('.post-id').value;
//        const commentItemContainer = button.closest('.re-comment-item-container') || button.closest('.comment-item-container');
//        const commentId = commentItemContainer.querySelector('.comment-id').value;
//        deleteComment(postId, commentId);
//    }else{
//        alert("삭제가 취소 되었습니다.");
//    }
//
//}
//
//function submitCommentForm(commentForm) {
//    const formData = new FormData(commentForm);
//    $.ajax({
//        url: commentForm.action,
//        type: "POST",
//        data: formData,
//        processData: false,
//        contentType: false,
//        success: function (data) {
//            $('.comment-container').html(data);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}
//
//function requestEditCommentForm(commentItemContainer, comment){
//    $.ajax({
//        url: '/comment/editForm',
//        type: "POST",
//        data: JSON.stringify(comment),
//        processData: false,
//        contentType: 'application/json',
//        success: function (data) {
//            $(commentItemContainer).children('.comment-item-body').replaceWith(data);
//            commentEditFormWordCount(commentItemContainer);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}
//
//function editCommentForm(commentForm,commentId){
//    const formData = new FormData(commentForm);
//    $.ajax({
//        url: "/comment/edit?id="+commentId,
//        type: "POST",
//        data: formData,
//        processData: false,
//        contentType: false,
//        success: function (data) {
//            $('.comment-container').html(data);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}
//
//function deleteComment(postId, commentId){
//    $.ajax({
//        url: "/comment/delete?postId="+postId+"&commentId="+commentId,
//        type: "DELETE",
//        processData: false,
//        contentType: false,
//        success: function (data) {
//            $('.comment-container').html(data);
//        },
//        error: function (error) {
//            console.log(error);
//        }
//    });
//}











//const submitButton = document.querySelector('.submit-button');
// 등록 버튼 클릭
//submitButton.addEventListener('click', () => {
//    handleSubmit("/coteboard/form");
//});

//const editButton=document.querySelector('.edit-button');
//editButton.addEventListener('click',()=>{
//    let postId = document.querySelector('.cote-id').value;
//    handleSubmit('/coteboard/edit?id='+postId);
//});
//
//function handleSubmit(url){
//    const title = document.querySelector('.title').value.trim();
//    const writer = document.querySelector('.writer').value.trim();
//    const boardPassword = document.querySelector('.boardPassword').value.trim();
//    const userPassword = document.querySelector('.userPassword').value.trim();
//    // 타이틀 또는 quizContent가 비어 있는 경우 알림창을 띄우고 폼을 제출하지 않음
//    if (!title || !contentEditor.getMarkdown()) {
//        alert('퀴즈 제목과 내용을 작성해주세요.');
//        return;
//    }
//    // 폼 데이터에 새로 생성된 태그 값들을 추가하는 JavaScript 코드 추가
//    const formData = new FormData();
//    formData.append('contents', contentEditor.getMarkdown());
//    formData.append('title', title);
//    formData.append('writer', writer);
//    formData.append('boardPassword', boardPassword);
//    formData.append('userPassword', userPassword);
//
//
//    // 폼 검증 통과 시
//    // 폼 데이터를 서버로 전송
//    $.ajax({
//        type: 'POST',
//        url: url,
//        data: formData,
//        contentType: false,
//        processData: false,
//        success: function (redirectUrl) {
//            location.href = redirectUrl;
//        },
//        error: function (error) {
//            console.error(error);
//        }
//    });
//}








