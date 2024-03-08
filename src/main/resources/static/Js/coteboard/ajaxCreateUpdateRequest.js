function clickCommentSubmitButton(button){
    document.querySelector("main").style.opacity= "0.15";
    document.querySelector(".modal_comment_post").style.display= "flex";
//    const commentForm=button.closest('.comment-form');
//    submitCommentForm(commentForm);
}

function clickReCommentSubmitButton(button){
    const commentForm=button.closest('.re-comment-form');
    console.log(commentForm) + '!!!';
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
    document.querySelector("main").style.opacity= "0.15";
    document.querySelector(".modal_recomment_delete").style.display= "flex";
    const postId = document.querySelector('.post-id').value;
}

function submitCommentForm(commentForm) {
    const formData = new FormData(commentForm);

    console.log(formData + "???");

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
