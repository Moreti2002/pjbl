import java.util.ArrayList;

import utils.ReadFile;

public class Main {
    public static void main(String args[]) {

        ArrayList<String> dados = new ArrayList<>();


        dados = ReadFile.Read();
        
        System.out.println(dados);

    }
}
