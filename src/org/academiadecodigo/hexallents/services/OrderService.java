package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.model.BQueue;
import org.academiadecodigo.hexallents.model.Delivery;
import org.academiadecodigo.hexallents.model.ItemType;
import org.academiadecodigo.hexallents.model.Order;

import java.util.Set;

/**
 * Created by codecadet on 13/03/2018.
 */
public class OrderService {


    private Delivery delivery;
    private Order order;
    private double finalPrice;
    private double price;


    public synchronized void addOrder() {
        order = new Order();
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public double buy(ItemType itemType, int amount) {
        return order.buy(itemType, amount);
    }

    public String orderList(int amount) {

        Set<ItemType> set = order.getOrderList().keySet();

        StringBuilder message = new StringBuilder();
        for (ItemType itemType : set) {

            price = buy(itemType, amount);

            String itemName = itemType.getItemName();

            message.append(itemName + " " + itemType.getPrice() + "\n");
        }

        finalPrice += price;


        return message.toString().concat(" " + "Final price " + Double.toString(finalPrice));
    }

    public void deliver() {
        delivery.deliveryOrder(order);
    }

    public Order getOrder() {
        return order;
    }
}
