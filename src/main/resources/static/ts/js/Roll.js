"use strict";
const div = document.createElement('div');
div.className = 'rollDiv';
div.style.position = 'absolute';
div.style.border = 'solid';
const d4 = document.createElement('button');
const d6 = document.createElement('button');
const d10 = document.createElement('button');
const d20 = document.createElement('button');
const d8 = document.createElement('button');
const dice = [d4, d6, d8, d10, d20];
dice.forEach(roll => {
    roll.className = roll.textContent;
});
document.body.appendChild(div);
//# sourceMappingURL=Roll.js.map