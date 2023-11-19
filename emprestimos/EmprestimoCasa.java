package emprestimos;
import classes.Cliente;

public class EmprestimoCasa extends Emprestimo {
    public EmprestimoCasa(Cliente cliente, double valor, double taxaJuros, int prazo) {
        super(cliente, valor, taxaJuros, prazo);
    }

    @Override
    public double calcularValorTotal() {
        return getValor() * (1 + getTaxaJuros() * getPrazo()) + 300;
    }

    @Override
    public void aprovarEmprestimo() {
        if (getCliente().verificarScoreCredito() >= 700) {
            setStatus("Aprovado");
        } else {
            setStatus("Reprovado");
        }
    }

    @Override
    public void imprimirContrato() {
        System.out.println("Contrato de Empréstimo para Casa");
        System.out.println("Cliente: " + getCliente().getNome());
        System.out.println("Valor: " + getValor());
        System.out.println("Taxa de Juros: " + getTaxaJuros());
        System.out.println("Prazo: " + getPrazo() + " meses");
        System.out.println("Status: " + getStatus());
    }
}