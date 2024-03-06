const submitButton = document.querySelector('.submit-button');
// 등록 버튼 클릭
submitButton.addEventListener('click', () => {
    handleSubmit("/coteboard/post");
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

    if (!title || !contentEditor.getMarkdown()) {
        alert('퀴즈 제목과 내용을 작성해주세요.');
        return;
    }
    // 폼 데이터에 새로 생성된 태그 값들을 추가하는 JavaScript 코드 추가
    const formData = new FormData();
    formData.append('title', title);
    formData.append('writer', writer);
    formData.append('boardPassword', boardPassword);
    formData.append('contents', contentEditor.getMarkdown());

    $.ajax({
        type: 'POST',
        url: url,
        data: formData,
        contentType: false,
        processData: false,
        success: function (redirectUrl) {
            console.log(redirectUrl);
            location.href = redirectUrl;
        },
        error: function (error) {
            console.error(error);
        }
    });
}