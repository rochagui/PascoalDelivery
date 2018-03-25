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
    private double price;
    private String itemName;


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
        order.placeItem(amount, itemType);
    }

    public String orderList() {

        Set<ItemType> set = order.getOrderList().keySet();

        StringBuilder message = new StringBuilder();
        for (ItemType itemType : set) {

            for (Integer amount : order.getOrderList().values()) {

                if (order.getOrderList().get(itemType) == amount) {

                    price = itemType.getPrice() * amount;

                    finalPrice = +price;

                    itemName = itemType.getItemName();

                    message.append(itemName + " " + price + "\n");
                }


            }
        }
        return message.toString().concat(" " + "Final price" + Double.toString(finalPrice));
    }
}
