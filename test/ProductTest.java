import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void mustAddStockSuccessfully() {

        Product product = new Product(1, "Notebook", 3500.0, 10);

        product.adicionarEstoque(5);

        assertEquals(15, product.getQuantityStock());
    }

    @Test
    void mustRemoveStockSuccessfully() {
        Product product = new Product(2, "Geladeira", 5000.0, 4);

        product.removerEstoque(2);

        assertEquals(2, product.getQuantityStock());
    }

    @Test
    void shouldNotAllowAddingNegativeStock() {
        Product product = new Product(3, "Celular", 4200.0, 15);

        assertThrows(IllegalArgumentException.class, () -> {
            product.adicionarEstoque(-5);
        });
    }

    @Test
    void shouldNotAllowRemovingNegativeQuantity() {
        Product product = new Product(4, "Carregador", 120.0, 30);

        assertThrows(IllegalArgumentException.class, () -> {
            product.removerEstoque(-5);
        });
    }

    @Test
    void shouldNotAllowRemovingaQuantityGreaterThanTheExistingAmount() {
        Product product = new Product(5, "Impressora", 2200.0, 8);

        assertThrows(IllegalArgumentException.class, () -> {
            product.removerEstoque(10);
        });
    }
}