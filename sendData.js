// Dados que você deseja enviar no formato JSON
const data = {
  "nome": "Exemplo",
  "idade": 30
};

const http = require('http');

// Configuração da solicitação
const options = {
  hostname: 'localhost',
  port: 8080,
  path: '/receberjson',
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Content-Length': JSON.stringify(data).length
  }
};

const req = http.request(options, (res) => {
  let responseData = '';

  res.on('data', (chunk) => {
    responseData += chunk;
  });

  res.on('end', () => {
    console.log('Resposta do servidor:', responseData);
  });
});

req.on('error', (error) => {
  console.error('Ocorreu um erro:', error);
});

// Enviando os dados JSON
req.write(JSON.stringify(data));
req.end();
