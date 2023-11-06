package classes;

public class Cliente extends Usuario {

    public Cliente(String nome, String email, int idade, String genero, String cpf,
                   String cidade, String estado_uf, String telefone) {

        super(nome, email, idade, genero, cpf, cidade, estado_uf, telefone, "cliente");
    }
    

    public void depositar() {}

}
