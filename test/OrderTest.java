import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void deveAdicionarProdutoNaOrderComSucesso() {
        Product product = new Product(1, "Mouse", 200.0, 5);

        Order order = new Order(1);

        order.addProduct(product, 5);

        assertEquals(1, order.getProducts().size());
        assertEquals(5, order.getProducts().get(product));
    }

    @Test
    void naoDeveAdicionarProdutoSemEstoqueSuficiente() {
        Product product = new Product(1, "Mouse", 200.0, 5);

        Order order = new Order(1);

        assertThrows(IllegalArgumentException.class, () -> {
            order.addProduct(product, 10);
        });
    }

    @Test
    void deveCalcularValorTotalDoPedidoComSucesso() {
        Product mouse = new Product(1, "Mouse", 200.0, 5);
        Product celular = new Product(1, "Celular", 3000.0, 5);

        Order order = new Order(1);
        order.addProduct(mouse, 5);
        order.addProduct(celular, 5);

        assertEquals(16000.0, order.totalValue());
    }
}
