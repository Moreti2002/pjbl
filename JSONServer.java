import com.sun.net.httpserver.HttpServer;

import utils.Dados;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Headers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONServer {
    public static void main(String[] args) throws Exception {
        int port = 8080; // Porta em que o servidor irá escutar

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Mapeia um contexto para receber os JSONs (por exemplo, /receberjson)
        server.createContext("/receberjson", new JSONHandler());

        server.setExecutor(null); // Use um executor padrão
        server.start();
        System.out.println("Servidor está escutando na porta " + port);
    }

    static class JSONHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // permitindo solicitações de qualquer origem
            Headers headers = exchange.getResponseHeaders();
            headers.set("Access-Control-Allow-Origin", "*");
            headers.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            headers.set("Access-Control-Allow-Headers", "Content-Type, Authorization");

            

            // le json de client
            InputStream requestBody = exchange.getRequestBody();
            InputStreamReader isr = new InputStreamReader(requestBody);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }

            // Processa o JSON
            String receivedJSON = json.toString();

            System.out.println("JSON recebido: " + receivedJSON);


            JSONParser parser = new JSONParser();


            
            try {
                Object obj = parser.parse(receivedJSON);
                JSONObject jsonObject = (JSONObject) obj;
    
                // Obtendo valores do JSON
                String tipo = (String) jsonObject.get("tipo");
                String email = (String) jsonObject.get("email");
                String senha = (String) jsonObject.get("senha");
            
                if (tipo.equals("login")) {
                    // login
                    String x = Autentica.autentica(email, senha);
                    if (x.equals("correta")) {
                        // redirecionar para pagina do cliente
                        // Envie uma resposta de sucesso
                        String resposta = "{\"mensagem\": \"Login bem-sucedido!\"}";
                        enviarResposta(exchange, 200, resposta);
                    } else {
                        // mandar json incorreta
                        // Envie uma resposta de sucesso
                        String resposta = "{\"mensagem\": \"Login falhou!\"}";
                        enviarResposta(exchange, 401, resposta);

                    }

                } else {
                    // cadastro
                    // verificar se email ja foi usado
                    String x = Autentica.autentica(email);

                    if (x.equals("existente")) {
                        // enviar json para mudar email
                        Autentica.autentica(email);

                        
                    } else {
                        String nome = (String) jsonObject.get("cadastroNome");
                        String genero = (String) jsonObject.get("cadastroGenero");
                        String cpf = (String) jsonObject.get("cadastroCpf");
                        String idade = (String) jsonObject.get("cadastroIdade");
                        String cidade = (String) jsonObject.get("cadastroCidade");
                        String estado_uf = (String) jsonObject.get("cadastroEstado_uf");
                        
                        Dados.salvar(email, senha, nome, genero, cpf, idade, cidade, estado_uf);
                        
                        // direcionar para pagina de usuario
                    }
                }


                // Imprimindo os valores separados
                System.out.println("E-mail: " + email);
                System.out.println("Senha: " + senha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // autenticacao

            // TODO: colocar novo campo no json de vinda --> "tipo": "login" ou "cadastro"

            // TODO: retornar json de retorno de senha correta ou de cadastro correto

            // 

            

            // Envie uma resposta de sucesso
            String response = "JSON recebido com sucesso!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    private static void enviarResposta(HttpExchange exchange, int statusCode, String resposta) throws IOException {
        exchange.sendResponseHeaders(statusCode, resposta.length());
        OutputStream os = exchange.getResponseBody();
        os.write(resposta.getBytes());
        os.close();
    }
}
 