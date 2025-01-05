"use strict";
function addLogEntry(message) {
    fetch('/log')
        .then(response => response.json())
        .then((logs) => {
        const logContainer = document.getElementById('log');
        logs.forEach(log => {
            const logDiv = document.createElement('div');
            logDiv.className = 'created-log';
            if (log.includes('[INFO]')) {
                logDiv.classList.add('log-info');
            }
            else if (log.includes('[ROLL]')) {
                logDiv.classList.add('log-roll');
            }
            else if (log.includes('[ERROR]')) {
                logDiv.classList.add('log-error');
            }
            logDiv.textContent = log + message;
            logContainer.appendChild(logDiv);
        });
        logContainer.scrollTop = logContainer.scrollHeight;
    });
}
//# sourceMappingURL=loger.js.map