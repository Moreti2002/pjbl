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
            // Se a resposta for bem-sucedida, ler o corpo da resposta
            return response.json();
        } else {
            throw new Error('Erro ao enviar os dados.');
        }
    })
    .then(function(data) {
        // Exibir os dados recebidos no alert
        alert('Dados recebidos com sucesso!\n' + JSON.stringify(data));
    })
    .catch(function(error) {
        // Exibir erro no alert em caso de falha
        console.error('Erro ao enviar ou receber os dados:', error);
        alert('Erro ao enviar ou receber os dados: ' + error.message);
    });
});
