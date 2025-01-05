"use strict";
document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.left-nav button');
    const divs = document.querySelectorAll('.main-body-div .screen  div');
    buttons.forEach(button => {
        button.addEventListener('click', () => {
            divs.forEach(div => div.style.display = 'none');
            const divToShow = document.querySelector('.' + button.textContent.toLowerCase());
            if (divToShow) {
                divToShow.style.display = 'flex';
            }
            addLogEntry(button.textContent);
        });
    });
});
//# sourceMappingURL=startPage.js.map