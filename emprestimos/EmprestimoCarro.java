package emprestimos;

import classes.Cliente;

public class EmprestimoCarro extends Emprestimo {
    public EmprestimoCarro(Cliente cliente, double valor, double taxaJuros, int prazo) {
        super(cliente, valor, taxaJuros, prazo);
    }

    @Override
    public double calcularValorTotal() {
        return getValor() * (1 + getTaxaJuros() * getPrazo()) + 200;
    }

    @Override
    public void aprovarEmprestimo() {
        if (getCliente().verificarScoreCredito() >= 620) {
            setStatus("Aprovado");
        } else {
            setStatus("Reprovado");
        }
    }

    @Override
    public void imprimirContrato() {
        System.out.println("Contrato de Empréstimo para Carro");
        System.out.println("Cliente: " + getCliente().getNome());
        System.out.println("Valor: " + getValor());
        System.out.println("Taxa de Juros: " + getTaxaJuros());
        System.out.println("Prazo: " + getPrazo() + " meses");
        System.out.println("Status: " + getStatus());
    }
}
