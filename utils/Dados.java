package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dados {

    public static List<String[]> ler() {

        List<String[]> data = new ArrayList<>();

        // Substitua o caminho do arquivo pelo caminho real do seu arquivo de entrada.
        String arquivo = "usuarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                data.add(partes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Converter a lista de arrays em uma matriz bidimensional.
        String[][] matriz = new String[data.size()][];
        data.toArray(matriz);
        
        return data;
    }

    public static void salvar(String email, String senha, String nome, String genero, String cpf, String idade, String cidade, String estado_uf) {



        try {
            // Create a BufferedWriter object for writing to the file in append mode
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true));

            // Write user data to the file on a new line
            writer.write(email + "," + senha + "," + nome + "," + genero + "," + cpf + "," + idade + "," + cidade + "," + estado_uf);
            writer.newLine(); // Move to the next line

            // Close the BufferedWriter to flush and close the file
            writer.close();


        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }   

    }

    public static void main(String[] args) {
        salvar("user@example.com", "senha123", "Nome Sobrenome", "Masculino", "123.456.789-01", "25", "Cidade", "UF");
    }
}