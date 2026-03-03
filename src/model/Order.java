package model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Map<Product, Integer> products;

    public Order(Integer id) {
        this.id = id;
        this.products = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getProducts() {
        return this.products;
    }

    public void addProduct(Product product, Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Não é possível adicionar uma quantidade de produto negativa");
        }

        products.put(product, quantidade);
        product.removerEstoque(quantidade);
    }

    public double totalValue() {
        double total = 0.0;

        for (Map.Entry<Product, Integer> item : products.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();

            total += product.getPrice() * quantity;
        }

        return total;
    }
}
