package emprestimos;
import classes.Cliente;



public abstract class Emprestimo {
    private Cliente cliente;
    private double valor;
    private double taxaJuros;
    private int prazo;
    private String status;

    public Emprestimo(Cliente cliente, double valor, double taxaJuros, int prazo) {
        this.cliente = cliente;
        this.valor = valor;
        this.taxaJuros = taxaJuros;
        this.prazo = prazo;
        this.status = "Pendente";
    }

    public abstract double calcularValorTotal();

    public abstract void aprovarEmprestimo();

    public abstract void imprimirContrato();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;

    }

    
}
