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


//게시글 정답 보기
const answerContainer = document.querySelector('.content-answer-container');
const answer = document.querySelector('.content-answer');
answerContainer.addEventListener('click', () => {
    // 배경이 회색으로 바뀐다.
    answerContainer.classList.toggle('hide-place');
    // 정답 text가 가려진다.
    answer.classList.toggle('hide-text');
});


// 게시물 좋아요 누르기
const likeButton = document.querySelector('.content-likes');

// 좋아요 개수 늘리기, 이미지 바꾸기 메서드
function likeControl(likeImage, likeNumber) {
    // 따봉 이미지 바꾸기
    likeImage.classList.toggle('liked');

    if (likeImage.classList.contains('liked')) {
        likeNumber.textContent = parseInt(likeNumber.textContent) + 1;
    } else {
        likeNumber.textContent = parseInt(likeNumber.textContent) - 1;
    }
}

// 게시글 좋아요 누르기
likeButton.addEventListener('click', (event) => {
    const likeNumber = likeButton.querySelector('.likes-number');
    const likeImage = likeButton.querySelector('img');
    likeControl(likeImage, likeNumber);
});

// 댓글 좋아요 누르기
const commentLikeButtons = document.querySelectorAll('.comment-likes')
commentLikeButtons.forEach((button) => {
    button.addEventListener('click', () => {
        const likeNumber = button.querySelector('.likes-number');
        const likeImage = button.querySelector('img');
        likeControl(likeImage, likeNumber);
    })
})
// 댓글 정답 보기
const commentAnswers = document.querySelectorAll('.hidden-comment-item-body');
commentAnswers.forEach((answer) => {
    answer.addEventListener('click', () => {
        answer.classList.toggle('hide-place');
        const comment = answer.querySelector('.comment-item');
        comment.classList.toggle('hide-text');
    });
})

//정답 댓글 작성
const commentEditorOpener = document.querySelector('.comment-editor-opener');
const commentEditor = document.querySelector('.comment-editor');
// 홍길동님,답변을 작성해보세요를 누르면 댓글 입력칸이 나온다.
commentEditorOpener.addEventListener('click', () => {
    commentEditorOpener.classList.toggle('hidden');
    commentEditor.classList.toggle('hidden');
})
// 취소 버튼을 누르면 사라진다.
const cancelButton = document.querySelector('.cancel-button');
cancelButton.addEventListener('click', () => {
    commentEditorOpener.classList.toggle('hidden');
    commentEditor.classList.toggle('hidden');
})


// 좋아요순 최신순 클릭
const recommend = document.querySelector('.recommend');
const recent = document.querySelector('.recent');
recommend.addEventListener('click', () => {
    recommend.classList.toggle('sorted');
    recent.classList.toggle('sorted');
})
recent.addEventListener('click', () => {
    recent.classList.toggle('sorted');
    recommend.classList.toggle('sorted');
})
