import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario(1000.0);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Commodities");
            System.out.println("2. Bancos");
            System.out.println("3. Eletricas");
            System.out.println("4. Saneamento");
            System.out.println("0. Sair");

            int escolha = scanner.nextInt();

            if (escolha == 0) {
                System.out.println("Saindo do programa.");
                break;
            }

            Investimento investimento = null;

            switch (escolha) {
                case 1:
                    investimento = new Commodities(500.0);
                    break;
                case 2:
                    investimento = new Bancos(700.0);
                    break;
                case 3:
                    investimento = new Eletricas(600.0);
                    break;
                case 4:
                    investimento = new Saneamento(450.0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.println("Nome do investimento: " + investimento.getNome());
            System.out.println("Valor do investimento: R$ " + investimento.getValor());

            usuario.retirarSaldo(investimento.getValor());

            Random random = new Random();
            boolean noticiaPositiva = random.nextBoolean();

            if (noticiaPositiva) {
                double variacao = investimento.getValor() * 0.1;
                usuario.adicionarSaldo(variacao);
                System.out.println("Notícia: Boas notícias! As ações estão em alta! Saldo variado em +" + variacao);
            } else {
                double variacao = investimento.getValor() * 0.1;
                usuario.retirarSaldo(variacao);
                System.out.println("Notícia: Infelizmente, as ações estão em baixa. Saldo variado em -" + variacao);
            }

            System.out.println("Saldo atual: R$ " + usuario.getSaldo());
        }

        scanner.close();
    }
}

