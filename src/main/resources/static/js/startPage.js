document.addEventListener('DOMContentLoaded', (event) =>{
    const buttons = document.querySelectorAll('.left-nav button');
    const divs = document.querySelectorAll('.main-body-div .screen > div');

    buttons.forEach(button => {
        button.addEventListener('click', () =>{
            divs.forEach(div => div.style.display = 'none');

            const divToShow = document.querySelector('.' + button.textContent.toLowerCase());

            if (divToShow){
                divToShow.style.display = 'flex';
            }
        });

        button.addEventListener('click', () =>{
            addLogEntry(button.textContent);
        } );

    });
});

