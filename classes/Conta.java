package classes;

public class Conta extends Cliente{
    int id_conta;
    int id_cliente;
    int id_gerente;
    float saldo;
    float credito;
    boolean ativa;

    // public Conta(int id_conta ,int id_cliente, int id_gerente, float saldo, float credito, boolean ativa) {
    //     this.id_conta = id_conta;
    //     this.id_cliente = id_cliente;
    //     this.id_gerente = id_gerente;
    //     this.saldo = saldo;
    //     this.credito = credito;
    //     this.ativa = ativa;
    // }

    public Conta(String nome, String email, int idade, String genero, String cpf,
                   String cidade, String estado_uf, String telefone) {

        super(nome, email, idade, genero, cpf, cidade, estado_uf, telefone);
    }
}
