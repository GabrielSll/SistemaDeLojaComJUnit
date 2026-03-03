import model.Product;
import service.ProductService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void deveCadastrarProdutosComSucesso() {
        ProductService service = new ProductService();

        service.cadastrarProduto(1, "Ventilador", 320.0, 25);

        Product produtoSalvo = service.buscarProduto(1);

        assertNotNull(produtoSalvo, "O produto deveria ter sido salvo e encontrado");
        assertEquals(1, produtoSalvo.getId());
    }

    @Test
    void naoDevePermitirCadastrarComIdDuplicado() {
        ProductService service = new ProductService();

        service.cadastrarProduto(1, "Ventilador", 320.0, 25);

        assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrarProduto(1, "Fone De Ouvido", 120.0, 10);
        });
    }

    @Test
    void deveAdicionarEstoqueComSucesso() {
        ProductService service = new ProductService();

        service.cadastrarProduto(1, "Ventilador", 320.0, 25);
        service.adicionarEstoque(1, 25);

        Product productSave = service.buscarProduto(1);

        assertEquals(50, productSave.getQuantidadeEstoque());
    }

    @Test
    void deveRemoverEstoqueComSucesso() {
        ProductService service = new ProductService();

        service.cadastrarProduto(1, "Ventilador", 320.0, 25);
        service.removerEstoque(1, 25);

        Product productSave = service.buscarProduto(1);

        assertEquals(0, productSave.getQuantidadeEstoque());
    }
}
