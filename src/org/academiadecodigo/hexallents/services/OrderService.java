package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.Order;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/**
 * Created by codecadet on 13/03/2018.
 */
public class OrderService extends AbstractService {

    private ExecutorService executorService;
    private OrderController orderController;
    private Queue<Order> queue;
    private Order order;

    public OrderService() {
        queue = new ConcurrentLinkedQueue<>();
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void addOrder() {
        order = new Order();
        queue.add(order);
    }
}
