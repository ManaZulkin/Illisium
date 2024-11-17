const div = document.createElement('div');
div.className = 'rollDiv';
div.style.position = 'absolute';
div.style.border = 'solid';

const d4 :HTMLButtonElement = document.createElement('button');
const d6 :HTMLButtonElement = document.createElement('button');
const d10 :HTMLButtonElement = document.createElement('button');
const d20 :HTMLButtonElement = document.createElement('button');
const d8 :HTMLButtonElement = document.createElement('button');

const dice: HTMLButtonElement[] = [d4, d6, d8, d10, d20];
dice.forEach(roll =>{
   roll.className = roll.textContent;

});

document.body.appendChild(div);
