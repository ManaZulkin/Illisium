"use strict";
document.addEventListener('DOMContentLoaded', (event) => {
    const buttons = document.querySelectorAll('.left-nav button');
    const divs = document.querySelectorAll('.main-body-div .screen > div');
    buttons.forEach(button => {
        button.addEventListener('click', () => {
            divs.forEach(div => div.style.display = 'none');
            const divToShow = document.querySelector('.' + button.textContent?.toLowerCase());
            if (divToShow) {
                divToShow.style.display = 'flex';
                // Set display to block for all divs inside divToShow
                const innerDivs = divToShow.querySelectorAll('div');
                innerDivs.forEach(innerDiv => {
                    innerDiv.style.display = 'block';
                });
            }
            addLogEntry(button.textContent || '');
        });
    });
});
//# sourceMappingURL=startPage.js.map