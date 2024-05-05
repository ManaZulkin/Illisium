const radioButtons = document.querySelectorAll('input[name="action"]')
const divs = {
    createBattle: document.getElementById('createBattleDiv'),
    managePlayers: document.getElementById('managePlayersDiv'),
    createQuest: document.getElementById('createQuestDiv')
};

radioButtons.forEach(radio=> {
    radio.addEventListener('change', () => {
        Object.values(divs).forEach(div =>{
            div.style.display = 'none';
        });
        if (radio.value){
            divs[radio.value].style.display = 'flex';
        }

    })
})