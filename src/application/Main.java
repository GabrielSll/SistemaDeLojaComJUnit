import model.Order;
import model.Product;
import service.OrderService;
import service.ProductService;

void main() {

    ProductService service = new ProductService();

    service.cadastrarProduto(1, "Celular", 3000.0, 15);
    service.cadastrarProduto(2, "Mouse", 200.0, 20);
    service.cadastrarProduto(3, "Fone de Ouvido", 120.0, 25);

    OrderService orderService = new OrderService();
    Order order = new Order(1);

    Product celular = service.buscarProduto(1);
    Product mouse = service.buscarProduto(2);
    Product fone = service.buscarProduto(3);

    order.addProduct(celular, 5);
    order.addProduct(mouse, 10);
    order.addProduct(fone, 2);

    orderService.saveOrder(order);

    for (Map.Entry<Product, Integer> item : order.getProducts().entrySet()) {
        Product product = item.getKey();
        Integer quantity = item.getValue();

        double subtotal = product.getPreco() * quantity;

        System.out.println(quantity + " x  | " + product.getNome() + " | R$ " + subtotal);
    }

    System.out.println("-------------------------------------");
    System.out.println("TOTAL A PAGAR:             R$ " + order.totalValue());
    System.out.println("=====================================");
}
