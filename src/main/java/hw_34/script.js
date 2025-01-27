let display = document.getElementById('display');
let expression = '';

document.addEventListener('keydown', function(event) {
    // Get the pressed key
    let key = event.key;

    if (!isNaN(key)) {
        inputValue(key);
    }

    if (key === '+' || key === '-' || key === '*' || key === '/') {
        inputValue(key);
    }

    if (key === 'Enter') {
        calculate();
    }

    if (key === 'Backspace') {
        backspace();
    }

    if (key === 'c' || key === 'C') {
        clearDisplay();
    }
});

function inputValue(value) {
    if (expression === '' && (value === '/' || value === '*' || value === '-' || value === '+')) {
        return;
    }
    expression += value;
    display.textContent = expression;
}

function calculate() {
    try {
        if (expression.includes('/0')) {
            display.textContent = "Error";
            expression = '';
            return;
        }
        let result = eval(expression);
        display.textContent = result;
        expression = result.toString();
    } catch (error) {
        display.textContent = "Error";
        expression = '';
    }
}

function clearDisplay() {
    expression = '';
    display.textContent = '0';
}

function backspace() {
    expression = expression.slice(0, -1);
    display.textContent = expression || '0';
}