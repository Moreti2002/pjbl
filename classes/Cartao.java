package classes;

public class Cartao {
    private int idConta;
    private static double limiteTotal;
    private double limiteDeCredito;

    public Cartao(int idConta, int numeroDeCartoes) {
        this.idConta = idConta;
        this.limiteDeCredito = limiteTotal / numeroDeCartoes;
        limiteTotal -= this.limiteDeCredito;
    }

    public static void definirLimiteTotal(double limite) {
        limiteTotal = limite;
    }

    public static double getLimiteTotal() {
        return limiteTotal;
    }

    public double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public static void main(String[] args) {
        Cartao.definirLimiteTotal(1000);
        int numeroDeCartoes = 2;

        Cartao c1 = new Cartao(1, numeroDeCartoes);
        Cartao c2 = new Cartao(1, numeroDeCartoes);
        Cartao c3 = new Cartao(1, numeroDeCartoes);

        
        System.out.println("Limite de crédito do Cartão c1: " + c1.getLimiteDeCredito());
        System.out.println("Limite de crédito do Cartão c2: " + c2.getLimiteDeCredito());
        System.out.println("Limite de crédito do Cartão c3: " + c3.getLimiteDeCredito());

        System.out.println("Limite total restante: " + Cartao.getLimiteTotal());
    }
}
