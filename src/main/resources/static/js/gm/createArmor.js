"use strict";
const newArmorUrl = 'http://localhost:8080//items/newArmor';
const getArmorUrl = 'http://localhost:8080//items/getArmorByName';
// const statsInputs = document.querySelectorAll('.stats-input');
document.addEventListener('DOMContentLoaded', () => {
    const createButton = document.querySelector('.create-button');
    createButton.addEventListener('click', () => {
        const armorForm = document.querySelector('.armor-form');
        if (!armorForm) {
            console.error('Armor form not found');
            return;
        }
        const armorName = armorForm.querySelector('.armor-name');
        const armorRare = armorForm.querySelector('.armor-rare');
        const armorType = armorForm.querySelector('.armor-type');
        if (!armorName || !armorRare || !armorType) {
            console.error('One or more form elements not found');
            return;
        }
        // Function to populate the select element with the options
        const populateSelect = (select, options) => {
            options.forEach(option => {
                const optionElement = document.createElement('option');
                optionElement.value = option;
                optionElement.textContent = option;
                select.appendChild(optionElement);
            });
        };
        // Fetch armor types and populate the select element
        fetch('http://localhost:8080/enum/armor-types')
            .then(response => response.json())
            .then((armorTypes) => {
            populateSelect(armorType, armorTypes);
        });
        // Fetch rare types and populate the select element
        fetch('http://localhost:8080/enum/rare-types')
            .then(response => response.json())
            .then((rareTypes) => {
            populateSelect(armorRare, rareTypes);
        });
    });
});
//# sourceMappingURL=createArmor.js.map