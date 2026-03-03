package model;

public class Product {
    private Integer id;
    private String nome;
    private double preco;
    private Integer quantidadeEstoque;

    public Product(Integer id, String nome, double preco, Integer quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço Inválido");
        }

        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Não é permitido adicionar uma quantidade negativa");
        }

        quantidadeEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Não é permitido remover uma quantidade negativa");
        }

        if (quantidade > quantidadeEstoque) {
            throw new IllegalArgumentException("Tentou remover mais do que já existe");
        }

        quantidadeEstoque -= quantidade;
    }

}
