class Produto {
    String codigo;
    String nome;
    double tamanhoPeso;
    String cor;
    double valor;
    int quantidadeEstoque;

    Produto(String codigo, String nome, double tamanhoPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoPeso = tamanhoPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }
}