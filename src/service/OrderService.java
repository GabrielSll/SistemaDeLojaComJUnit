package service;

import model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    Map<Integer, Order> orders;

    public OrderService() {
        this.orders = new HashMap<>();
    }

    public void saveOrder(Order order) {
        if (orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Pedido com este ID já existe");
        }

        orders.put(order.getId(), order);
    }

    public Order findOrder(Integer id) {
        return orders.get(id);
    }
}
