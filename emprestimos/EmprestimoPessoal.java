package emprestimos;

import classes.Cliente;

public class EmprestimoPessoal extends Emprestimo {
    public EmprestimoPessoal(Cliente cliente, double valor, double taxaJuros, int prazo) {
        super(cliente, valor, taxaJuros, prazo);
    }

    @Override
    public double calcularValorTotal() {
        return getValor() * (1 + getTaxaJuros() * getPrazo());
    }

    @Override
    public void aprovarEmprestimo() {
        if (getCliente().verificarScoreCredito() >= 600) {
            setStatus("Aprovado");
        } else {
            setStatus("Reprovado");
        }
    }

    @Override
    public void imprimirContrato() {
        System.out.println("Contrato de Empréstimo Pessoal");
        System.out.println("Cliente: " + getCliente().getNome());
        System.out.println("Valor: " + getValor());
        System.out.println("Taxa de Juros: " + getTaxaJuros());
        System.out.println("Prazo: " + getPrazo() + " meses");
        System.out.println("Status: " + getStatus());
    }
}
