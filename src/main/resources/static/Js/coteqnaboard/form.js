//제목 칸 늘리기
function autoResize(textarea) {
    //height초기화
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight+ 'px';
}
window.onload = function() {
    autoResize(document.querySelector('.title'));
};

// 과목별로 세무과목 바꿔주기
const subjectTagButtons=document.querySelectorAll('.subject-tag-button');
const detailTagsContainer = document.querySelectorAll('.detail-tags');

//과목 클릭 시 그 과목에 해당하는 세부과목 보여주기
subjectTagButtons.forEach((button)=>{
    button.addEventListener('click',()=>{
        showDetailTagButtons(button);
    })
});

//세부과목 바꿔주는 메서드
function showDetailTagButtons(subject){
    // 클릭한 과목 꺼내오기
    const subjectName = subject.textContent.toLowerCase();
    const selectedTagsContainer = document.querySelector(`.${subjectName}`);

    // 모든 detailTagsContainer에 hidden 클래스 추가
    detailTagsContainer.forEach(tag => tag.classList.add('hidden'));

    // 클릭된 버튼과 이름이 동일한 세부과목 div에 hidden 제거
    selectedTagsContainer.classList.remove('hidden');

    //선택된 과목 바꿔주기(border-bottom에 흰 선이 생긴다)
    subjectTagButtons.forEach((button)=>{
        button.classList.remove('selected-subject');
    })
    subject.classList.add('selected-subject');
}

//태그 선택하기
const detailsTagButtons = document.querySelectorAll('.detail-tag-button');
const selectedTagsContainer = document.querySelector('.selected-tags');

//세부과목 버튼 누를때마다 색깔 바뀜, 태그 생성 기능
detailsTagButtons.forEach(button => {
    button.addEventListener('click', () => {
        // 세부과목 버튼 색깔 바뀜
        button.classList.toggle('selected');
        //태그 추가 / 제거
        if (button.classList.contains('selected')) {
            const selectedTag=createSelectedTag(button);
            // 생성된 태그를 '선택된 태그들:'뒤에 태그 추가
            selectedTagsContainer.appendChild(selectedTag);
        } else {
            const buttonValue=button.value;
            // 태그 버튼을 한 번 더 눌렀을 경우 삭제
            const removeTag = document.querySelector(`.selected-tag[value="${buttonValue}"]`);
            selectedTagsContainer.removeChild(removeTag);
        }
    });
});

// 선택한 태그 생성 메서드
function createSelectedTag(button){
    const buttonText = button.textContent;
    const selectedTag = document.createElement('button');
    selectedTag.classList.add('selected-tag');
    selectedTag.textContent = buttonText;
    selectedTag.value = button.value;

    return selectedTag;
}

// 취소 버튼 클릭
const cancelButton = document.querySelector('.cancel-button');
cancelButton.addEventListener('click', () => {
    // 취소
    location.href = '/quiz';
});