package service;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    Map<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void registerProduct(Integer id, String name, double price, Integer quantitystock) {
        if (products.containsKey(id)) {
            throw new IllegalArgumentException("Produto já cadastrado!");
        }

        Product product = new Product(id, name, price, quantitystock
        );

        products.put(id, product);
    }

    public Product findProduct(Integer id) {
        return products.get(id);
    }

    public void addStock(Integer id, Integer quantity) {
        Product product = findProduct(id);

        if (product == null) {
            throw new IllegalArgumentException("Produto não existe");
        }

        product.adicionarEstoque(quantity);
    }

    public void removeStock(Integer id, Integer quantity) {
        Product product = findProduct(id);

        if (product == null) {
            throw new IllegalArgumentException("Produto não existe");
        }

        product.removerEstoque(quantity);
    }
}
