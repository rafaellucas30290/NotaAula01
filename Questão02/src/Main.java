import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ControleEstoque controleEstoque = new ControleEstoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Realizar venda");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (opcao == 1) {
                System.out.print("Código: ");
                String codigo = scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Tamanho/Peso: ");
                double tamanhoPeso = scanner.nextDouble();
                scanner.nextLine(); // Consumir nova linha
                System.out.print("Cor: ");
                String cor = scanner.nextLine();
                System.out.print("Valor: ");
                double valor = scanner.nextDouble();
                System.out.print("Quantidade no estoque: ");
                int quantidadeEstoque = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                Produto produto = new Produto(codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);
                controleEstoque.cadastrarProduto(produto);
            } else if (opcao == 2) {
                System.out.print("Código do produto: ");
                String codigo = scanner.nextLine();
                System.out.print("Forma de pagamento (Pix, Espécie, Transferência, Débito, Crédito): ");
                String formaPagamento = scanner.nextLine();
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                controleEstoque.realizarVenda(codigo, formaPagamento, quantidade);
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}