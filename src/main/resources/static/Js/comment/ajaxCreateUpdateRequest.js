//댓글 등록 버튼,등록 폼
const submitCommentButton = document.querySelector('.submit-button');
const commentForm = document.querySelector('.comment-form');

//대댓글 등록 버튼, 등록 폼
const submitRecommentButton = document.querySelector('.re-comment-submit-button');
const reCommentForm = document.querySelector('.re-comment-form');

submitCommentButton.addEventListener('click', () => {
    console.log("클릭");
    submitCommentForm(commentForm, "comment");
});

submitRecommentButton.addEventListener('click', () => {
    submitCommentForm(reCommentForm, "recomment");
})

function submitCommentForm(commentForm, type) {
    const formData = new FormData(commentForm);
    console.log(commentForm.action);
    $.ajax({
        url: commentForm.action,
        type: "POST",
        data: formData,
        processData: false,
        contentType: false,
        success: function (data) {
            console.log(data);

            (type='comment')? appendNewComment(data) : "";
        },
        error: function (error) {
            console.log(error);
        }
    });
}

//새로운 댓글을 현재 페이지에 추가하는 함수
function appendNewComment(comment) {
    const commentsContainer =document.querySelector('.cont-main');

    let newCommentDiv = document.createElement('div');
    newCommentDiv.className = 'comment-item-container';
    newCommentDiv.value = comment.id;

    // 새로운 댓글의 HTML 작성
    newCommentDiv.innerHTML = `
        <div class="comment-item-header">
            <a href="" class="comment-writer-name" th:value="${comment.userId}" th:text="${comment.author}"></a>
            <p class="comment-createdAt" th:text=""></p>
        </div>
        <div class="${comment.display == 0 ? 'comment-item-body' : 'hidden-comment-item-body hide-place'}">
            <div class="comment-item ${comment.display == 0 ? '' : 'hide-text'}">${comment.contents}</div>
        </div>
        <div class="comment-item-bottom">
            <div class="etc-button-container">
                <button class="btn comment-button re-comment-display-control">
                    <img th:src="@{/images/icon_up_arrow.png}" alt="숨기기 버튼"> 숨기기
                </button>
                <button class="btn comment-button re-comment-editor-opener">
                    <img th:src="@{/images/icon_recomment.png}" alt="답글달기 버튼">답글 달기
                </button>
            </div>
            <button class="btn likes-button comment-button comment-likes">
                <img th:src="@{/images/icon_like_normal.png}" alt="좋아요 버튼">
                <p class="likes-number" th:text="${comment.like}"></p>
            </button>
        </div>
        
        <div class="re-comment-editor hidden">
            <form class="re-comment-form" th:action="@{/comment/add}" th:method="post">
                <input type="hidden" name="postId" th:value="${quiz.id}"/>

                <input type="hidden" name="display" th:value="false"/>
                <input type="hidden" name="parentCommentId" th:value="${comment.id}"/>

                <textarea class="answer-input" placeholder="댓글을 작성해보세요" rows="30"></textarea>


                <div class="comment-editor-bottom">
                    <button class="btn re-comment-cancel-button" type="button">취소</button>
                    <button class="btn re-comment-submit-button" type="button">등록</button>
                </div>
            </form>
        </div>
        
        <div class="re-comment-items-container"></div>
    </div>
    `;

    // 새로운 댓글을 현재 페이지의 댓글 컨테이너에 추가
    commentsContainer.appendChild(newCommentDiv);
}