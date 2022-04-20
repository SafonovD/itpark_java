$(function () {
    let rublesInUsd;

    $.ajax({
        url: '/currency?code=USD',
        type: 'GET',
        success: function (data) {
            rublesInUsd = data.value;
            console.log('Текущий курс доллара в рублях ' + rublesInUsd);
        }
    });

    $('#calculateButton').click(function () {
        let currency = $('#currencyValue').val();
        let currencyNumber;
        if (!currency || isNaN(currencyNumber = parseInt(currency, 10)) ||
            currencyNumber < 0) {
            alert('Введенное значение некорректно, конвертация невозможна');
            return;
        }
        $('#calculateButton').val(currencyNumber);
        currencyNumber *= rublesInUsd;
        console.log('Результат вычисления '+ currencyNumber);
        $('#result').text('Результат конвертации : ' + currencyNumber + ' рублей');

    });
});
