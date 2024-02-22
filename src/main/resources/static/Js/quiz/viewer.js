$(document).ready(function () {
        const content = toastui.Editor.factory({
            el: document.querySelector(".content-detail"),
            viewer: true,
            useScript: true,
            initialValue: quizContent,
        });
        const answer = toastui.Editor.factory({
            el: document.querySelector(".content-answer"),
            viewer: true,
            useScript: true,
            initialValue: answerContent,
        });
    }
);