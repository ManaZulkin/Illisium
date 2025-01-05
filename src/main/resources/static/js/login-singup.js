"use strict";
document.addEventListener('DOMContentLoaded', (event) => {
    const buttons = document.querySelectorAll('.actions-head button');
    const divs = document.querySelectorAll('.login-sing-up-div div');
    buttons.forEach(button => {
        button.addEventListener('click', () => {
            divs.forEach(div => div.style.display = 'none');
            const divToShow = document.querySelector('.' + button.textContent?.toLowerCase());
            if (divToShow) {
                divToShow.style.display = 'flex';
            }
        });
    });
});
//# sourceMappingURL=login-singup.js.map