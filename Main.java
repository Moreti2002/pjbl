package web;

import emprestimos.*;

import java.util.Scanner;

import classes.Cliente;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Obter a escolha do usuário para o tipo de empréstimo
            System.out.println("Escolha o tipo de empréstimo:");
            System.out.println("1. Empréstimo para Carro");
            System.out.println("2. Empréstimo para Casa");
            System.out.println("3. Empréstimo Pessoal");
            System.out.println("4. Empréstimo para Viagem");
            int tipoEmprestimo = scanner.nextInt();

            // Obter a escolha do usuário para o valor de entrada
            System.out.println("Deseja fornecer um valor de entrada? (sim/não)");
            String escolhaEntrada = scanner.next();
            boolean temEntrada = escolhaEntrada.equalsIgnoreCase("sim");
            double valorEntrada = 0;

            if (temEntrada) {
                System.out.println("Digite o valor de entrada:");
                valorEntrada = scanner.nextDouble();
            }

            // Criar um cliente para o empréstimo
            Cliente cliente = new Cliente("Fulano de Tal", "fulano@example.com", 35, "Masculino", "123456789", "Cidade", "Estado", "987654321");

            // Criar o tipo de empréstimo selecionado
            Emprestimo emprestimo = null;

            switch (tipoEmprestimo) {
                case 1:
                    emprestimo = new EmprestimoCarro(cliente, 10000, 0.018, 12);
                    break;
                case 2:
                    emprestimo = new EmprestimoCasa(cliente, 50000, 0.018, 24);
                    break;
                case 3:
                    emprestimo = new EmprestimoPessoal(cliente, 5000, 0.018, 36);
                    break;
                case 4:
                    emprestimo = new EmprestimoViagem(cliente, 2000, 0.018, 12);
                    break;
                default:
                    System.out.println("Opção de empréstimo inválida.");
                    return;
            }

            // Definir o valor de entrada no empréstimo, se houver
            emprestimo.setValor(emprestimo.getValor() - valorEntrada);

            // Mostrar as parcelas para 12, 24 e 36 meses com ou sem valor de entrada
            int[] prazos = {12, 24, 36};

            for (int prazo : prazos) {
                emprestimo.setPrazo(prazo);
                double valorTotal = emprestimo.calcularValorTotal();
                double valorParcela = valorTotal / prazo;

                System.out.println("\nParcelas para " + prazo + " meses:");

                for (int i = 1; i <= prazo; i++) {
                    System.out.println("Mês " + i + ": R$ " + valorParcela);
                }
            }
        }
    }
}