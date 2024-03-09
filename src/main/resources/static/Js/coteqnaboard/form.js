const byteLimit = 3000;
const titleByteLimit = 250;

//제목 칸 늘리기
function autoResize(textarea) {
    //height초기화
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight+ 'px';
}
window.onload = function() {
    autoResize(document.querySelector('.title'));
};

// 취소 버튼 클릭
const cancelButton = document.querySelector('.cancel-button');
cancelButton.addEventListener('click', () => {
    // 취소
    location.href = '/quiz';
});


function clickCommentSubmitButton(button){
    document.querySelector("main").style.opacity= "0.15";
    document.querySelector(".modal").style.display= "flex";
//    const commentForm=button.closest('.comment-form');
//    submitCommentForm(commentForm);
}

function clickReCommentSubmitButton(button){
    const commentForm=button.closest('.re-comment-form');
    submitCommentForm(commentForm);
}

function clickCommentEditButton(button){
    const commentForm=button.closest('.comment-form');
    const commentItemContainer= button.closest('.re-comment-item-container') || button.closest('.comment-item-container');
    const commentId= commentItemContainer.querySelector('.comment-id').value;
    editCommentForm(commentForm, commentId);
}

//삭제 버튼
function  clickDeleteButton(button){

    const confirmed= window.confirm("정말 삭제하시겠습니까?");

    if(confirmed) {
        const postId = document.querySelector('.post-id').value;
        const commentItemContainer = button.closest('.re-comment-item-container') || button.closest('.comment-item-container');
        const commentId = commentItemContainer.querySelector('.comment-id').value;
        deleteComment(postId, commentId);
    }else{
        alert("삭제가 취소 되었습니다.");
    }

}

function submitCommentForm(commentForm) {
    const formData = new FormData(commentForm);
    $.ajax({
        url: commentForm.action,
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

function requestEditCommentForm(commentItemContainer, comment){
    $.ajax({
        url: '/comment/editForm',
        type: "POST",
        data: JSON.stringify(comment),
        processData: false,
        contentType: 'application/json',
        success: function (data) {
            $(commentItemContainer).children('.comment-item-body').replaceWith(data);
            commentEditFormWordCount(commentItemContainer);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function editCommentForm(commentForm,commentId){
    const formData = new FormData(commentForm);
    $.ajax({
        url: "/comment/edit?id="+commentId,
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

function deleteComment(postId, commentId){
    $.ajax({
        url: "/comment/delete?postId="+postId+"&commentId="+commentId,
        type: "DELETE",
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











const submitButton = document.querySelector('.submit-button');
// 등록 버튼 클릭
submitButton.addEventListener('click', () => {
    handleSubmit("/coteboard/form");
});

const editButton=document.querySelector('.edit-button');
editButton.addEventListener('click',()=>{
    let postId = document.querySelector('.cote-id').value;
    handleSubmit('/coteboard/edit?id='+postId);
});

function handleSubmit(url){
    const title = document.querySelector('.title').value.trim();
    const writer = document.querySelector('.writer').value.trim();
    const boardPassword = document.querySelector('.boardPassword').value.trim();
    const userPassword = document.querySelector('.userPassword').value.trim();
    // 타이틀 또는 quizContent가 비어 있는 경우 알림창을 띄우고 폼을 제출하지 않음
    if (!title || !contentEditor.getMarkdown()) {
        alert('퀴즈 제목과 내용을 작성해주세요.');
        return;
    }
    // 폼 데이터에 새로 생성된 태그 값들을 추가하는 JavaScript 코드 추가
    const formData = new FormData();
    formData.append('contents', contentEditor.getMarkdown());
    formData.append('title', title);
    formData.append('writer', writer);
    formData.append('boardPassword', boardPassword);
    formData.append('userPassword', userPassword);


    // 폼 검증 통과 시
    // 폼 데이터를 서버로 전송
    $.ajax({
        type: 'POST',
        url: url,
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
}
