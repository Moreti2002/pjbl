package classes;

public class Gerente extends Usuario {
    String setor; // apenas gerentes comerciais podem ser associados a contas de clientes

    public Gerente(String nome, String email, int idade, String genero, String cpf,
    String cidade, String estado_uf, String telefone, String setor) {

    super(nome, email, idade, genero, cpf, cidade, estado_uf, telefone, "gerente");
    this.setor = setor;
    }

}
