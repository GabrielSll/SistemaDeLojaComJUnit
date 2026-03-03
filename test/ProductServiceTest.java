import model.Product;
import service.ProductService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void mustRegisterProductsSuccessfully() {
        ProductService service = new ProductService();

        service.registerProduct(1, "Ventilador", 320.0, 25);

        Product saveProduct = service.findProduct(1);

        assertNotNull(saveProduct, "O produto deveria ter sido salvo e encontrado");
        assertEquals(1, saveProduct.getId());
    }

    @Test
    void shouldNotAllowRegistrationWithDuplicateID() {
        ProductService service = new ProductService();

        service.registerProduct(1, "Ventilador", 320.0, 25);

        assertThrows(IllegalArgumentException.class, () -> {
            service.registerProduct(1, "Fone De Ouvido", 120.0, 10);
        });
    }

    @Test
    void mustAddStockWithSucess() {
        ProductService service = new ProductService();

        service.registerProduct(1, "Ventilador", 320.0, 25);
        service.addStock(1, 25);

        Product productSave = service.findProduct(1);

        assertEquals(50, productSave.getQuantityStock());
    }

    @Test
    void mustRemoveStockWithSucess() {
        ProductService service = new ProductService();

        service.registerProduct(1, "Ventilador", 320.0, 25);
        service.removeStock(1, 25);

        Product productSave = service.findProduct(1);

        assertEquals(0, productSave.getQuantityStock());
    }
}
