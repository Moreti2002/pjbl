class Usuario {
    private double saldo;

    public Usuario(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        saldo += valor;
        System.out.println("Adicionado R$ " + valor + " ao saldo. Saldo atual: R$ " + saldo);
    }

    public void retirarSaldo(double valor) {
        saldo -= valor;
        System.out.println("Retirado R$ " + valor + " do saldo. Saldo atual: R$ " + saldo);
    }
}