function clickCommentSubmitButton(button){
    const commentForm=button.closest('.comment-form');
    submitCommentForm(commentForm);
}

function clickReCommentSubmitButton(button){
    const commentForm=button.closest('.re-comment-form');
    submitCommentForm(commentForm);
}


function submitCommentForm(commentForm) {
    const formData = new FormData(commentForm);
    console.log(commentForm.action);
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