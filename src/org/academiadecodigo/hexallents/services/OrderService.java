package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.ItemType;
import org.academiadecodigo.hexallents.model.Order;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by codecadet on 13/03/2018.
 */
public class OrderService {


    private OrderController orderController;
    private Queue<Order> queue;
    private Order order;
    private double finalPrice;
    private String itemName;
    private double price;


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


    public double buy(ItemType itemType, int amount) {
        return order.buy(itemType, amount);
    }

    public String orderList(int amount) {

        Set<ItemType> set = order.getOrderList().keySet();

        StringBuilder message = new StringBuilder();
        for (ItemType itemType : set) {

            price = buy(itemType, amount);

            itemName = itemType.getItemName();

            message.append( itemName + " " + itemType.getPrice() + "\n");
        }

        finalPrice += price;

        return message.toString().concat(" " + "Final price " + Double.toString(finalPrice));
    }
}
