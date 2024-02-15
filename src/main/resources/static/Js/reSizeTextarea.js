function autoResize(textarea) {
    //height초기화
    textarea.style.height = 'auto';
    textarea.style.height = textarea.scrollHeight+ 'px';
}