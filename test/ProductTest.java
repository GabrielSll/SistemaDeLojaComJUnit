import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void deveAdicionarEstoqueComSucesso() {

        Product produto = new Product(1, "Notebook", 3500.0, 10);

        produto.adicionarEstoque(5);

        assertEquals(15, produto.getQuantidadeEstoque());
    }

    @Test
    void deveRemoverEstoqueComSucesso() {
        Product produto = new Product(2, "Geladeira", 5000.0, 4);

        produto.removerEstoque(2);

        assertEquals(2, produto.getQuantidadeEstoque());
    }

    @Test
    void naoDevePermitirAdicionarEstoqueNegativo() {
        Product produto = new Product(3, "Celular", 4200.0, 15);

        assertThrows(IllegalArgumentException.class, () -> {
            produto.adicionarEstoque(-5);
        });
    }

    @Test
    void naoDevePermitirRemoverQuantidadeNegativa() {
        Product produto = new Product(4, "Carregador", 120.0, 30);

        assertThrows(IllegalArgumentException.class, () -> {
           produto.removerEstoque(-5);
        });
    }

    @Test
    void naoDevePermitirRemoverQuantidadeMaiorQueAExistente() {
        Product produto = new Product(5, "Impressora", 2200.0, 8);

        assertThrows(IllegalArgumentException.class, () -> {
           produto.removerEstoque(10);
        });
    }
}