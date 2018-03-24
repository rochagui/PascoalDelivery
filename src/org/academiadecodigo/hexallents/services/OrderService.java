package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.ItemType;
import org.academiadecodigo.hexallents.model.Order;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/**
 * Created by codecadet on 13/03/2018.
 */
public class OrderService {

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

    public void placeItem(int amount, ItemType itemType) {
        if (amount < 0) {
            order.removeAmountItem(amount, itemType);
        }
        order.placeItem(amount, itemType);
        orderList();
    }

    public String orderList() {
        Set<ItemType> set = order.getOrderList().keySet();
        StringBuilder message = new StringBuilder();
        for (Integer amount : order.getOrderList().values()) {
            for (ItemType itemType : set) {
                double finalPrice = itemType.getPrice() * amount;
                message.append(itemType.getItemName() + finalPrice +"\n");
            }
        }
        return message.toString();
    }
}
