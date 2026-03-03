import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;
import service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    @Test
    void deveCriarPedidoComSucesso() {
        Product product = new Product(1, "VideoGame", 5000.0, 4);

        Order order = new Order(1);

        order.addProduct(product, 1);

        OrderService service = new OrderService();

        service.saveOrder(order);
        Order saveOrder = service.findOrder(1);

        assertNotNull(saveOrder, "O pedido deveria ter sido encontrado no service");
        assertEquals(1, saveOrder.getId());
        assertEquals(5000.0, saveOrder.totalValue());
    }
}
