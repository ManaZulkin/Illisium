function addLogEntry(message: string): void {
    fetch('/log')
        .then(response => response.json())
        .then((logs: string[]) => {
            const logContainer = document.getElementById('log') as HTMLDivElement;
            logs.forEach(log => {
                const logDiv = document.createElement('div');
                logDiv.className = 'created-log';

                if (log.includes('[INFO]')) {
                    logDiv.classList.add('log-info');
                } else if (log.includes('[ROLL]')) {
                    logDiv.classList.add('log-roll');
                } else if (log.includes('[ERROR]')) {
                    logDiv.classList.add('log-error');
                }

                logDiv.textContent = log + message;
                logContainer.appendChild(logDiv);
            });
            logContainer.scrollTop = logContainer.scrollHeight;
        });
}