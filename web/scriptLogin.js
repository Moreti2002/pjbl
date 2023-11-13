document.getElementById('submit').addEventListener('click', function(event) {
    event.preventDefault(); // Evitar o envio padrão do formulário

    // Coletar os valores do email e senha do formulário
    var email = document.getElementById('email').value;
    var senha = document.getElementById('senha').value;

    // Criar um objeto JSON com os dados
    var dados = {
        email: email,
        senha: senha
    };

    // Enviar os dados para o servidor
    fetch('http://127.0.0.1:8080/receberjson', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(function(response) {
        if (response.status === 200) {
            alert('Dados enviados com sucesso!');
        } else {
            alert('Erro ao enviar os dados.');
        }
    })
    .catch(function(error) {
        alert('Erro ao enviar os dados: ' + error);
    });
});

