import java.util.List;
import utils.Dados;

public class Main {


    public static String autentica(String EMAIL, String SENHA) {
        List<String[]> dados = Dados.ler();
    
        for (String[] linha : dados) {
            String email = linha[1];
            String senha = linha[2];
    
            if (email.equals(EMAIL) && senha.equals(SENHA)) {
                return "correta";
            }
        }
    
        return "incorreto";
    }
    


    public static void main(String[] args) {

    String x = autentica("john@asdas.com", "secreta123");

    System.out.println(x);


    }
}
