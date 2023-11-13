document.addEventListener('DOMContentLoaded', function () {
  const cadastrarButton = document.getElementById('cadastrarCadastroButton');

  cadastrarButton.addEventListener('click', function () {
      const email = document.getElementById('cadastroEmail').value;
      const senha = document.getElementById('cadastroSenha').value;
      const nome = document.getElementById('cadastroNome').value;
      const genero = document.getElementById('cadastroGenero').value;
      const cpf = document.getElementById('cadastroCpf').value;
      const idade = document.getElementById('cadastroIdade').value;
      const cidade = document.getElementById('cadastroCidade').value;
      const estado_uf = document.getElementById('cadastroEstado_uf').value;

      const data = {
          tipo: "cadastro",
          email: email,
          senha: senha,
          nome: nome,
          genero: genero,
          cpf: cpf,
          idade: idade,
          cidade: cidade,
          estado_uf: estado_uf
      };

      fetch('http://127.0.0.1:8080/receberjson', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(data)
      })
          .then(response => response.json())
          .then(result => {
              console.log(result);
              // Faça algo com a resposta do servidor, se necessário
          })
          .catch(error => {
              console.error('Erro:', error);
          });
  });
});