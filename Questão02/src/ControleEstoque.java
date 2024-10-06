import java.util.ArrayList;
import java.util.Scanner;

class ControleEstoque {
    private ArrayList<Produto> produtos;

    public ControleEstoque() {
        produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto.nome);
    }

    public void realizarVenda(String codigo, String formaPagamento, int quantidade) {
        Produto produto = buscarProduto(codigo);
        if (produto != null && produto.quantidadeEstoque >= quantidade) {
            double valorFinal = produto.valor * quantidade;

            if (formaPagamento.equalsIgnoreCase("Pix") || formaPagamento.equalsIgnoreCase("Espécie")
                    || formaPagamento.equalsIgnoreCase("Transferência") || formaPagamento.equalsIgnoreCase("Débito")) {
                valorFinal *= 0.95; // Aplicar 5% de desconto
            } else if (formaPagamento.equalsIgnoreCase("Crédito")) {
                // Crédito, sem desconto, mas pode parcelar
                System.out.println("Valor a ser pago: " + valorFinal);
                System.out.println("Você pode parcelar em 3x sem juros.");
                return;
            }

            System.out.println("Valor total: " + valorFinal);
            if (formaPagamento.equalsIgnoreCase("Espécie")) {
                System.out.print("Digite o valor pago: ");
                Scanner scanner = new Scanner(System.in);
                double valorPago = scanner.nextDouble();
                if (valorPago > valorFinal) {
                    double troco = valorPago - valorFinal;
                    System.out.println("Troco: " + troco);
                }
            }

            produto.quantidadeEstoque -= quantidade;
            System.out.println("Venda realizada com sucesso! Produto: " + produto.nome);
        } else {
            System.out.println("Produto não encontrado ou quantidade insuficiente.");
        }
    }

    private Produto buscarProduto(String codigo) {
        for (Produto p : produtos) {
            if (p.codigo.equals(codigo)) {
                return p;
            }
        }
        return null;
    }
}
