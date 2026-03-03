package service;
import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    Map<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void cadastrarProduto(Integer id, String nome, double preco, Integer quantidadeEstoque) {
        if (products.containsKey(id)) {
            throw new IllegalArgumentException("Produto já cadastrado!");
        }

        Product product = new Product(id, nome, preco, quantidadeEstoque);

        products.put(id, product);
    }

    public Product buscarProduto(Integer id) {
        return products.get(id);
    }

    public void adicionarEstoque(Integer id, Integer quantidade) {
        Product product = buscarProduto(id);

        if (product == null) {
            throw new IllegalArgumentException("Produto não existe");
        }

        product.adicionarEstoque(quantidade);
    }

    public void removerEstoque(Integer id, Integer quantidade) {
        Product product = buscarProduto(id);

        if (product == null) {
            throw new IllegalArgumentException("Produto não existe");
        }

        product.removerEstoque(quantidade);
    }
}
