package model;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private Integer quantityStock;

    public Product(Integer id, String name, double price, Integer quantityStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Preço Inválido");
        }

        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void adicionarEstoque(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Não é permitido adicionar uma quantidade negativa");
        }

        quantityStock += quantity;
    }

    public void removerEstoque(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Não é permitido remover uma quantidade negativa");
        }

        if (quantity > quantityStock) {
            throw new IllegalArgumentException("Tentou remover mais do que já existe");
        }

        quantityStock -= quantity;
    }

}
