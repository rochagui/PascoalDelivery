package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.ItemType;
import org.academiadecodigo.hexallents.model.Order;

import java.util.Set;

/**
 * Created by codecadet on 13/03/2018.
 */
public class OrderService implements Runnable {


<<<<<<< HEAD
    private OrderController orderController;
=======
    private Delivery delivery;
>>>>>>> 07e86d7403182673e5ab76e238baf28ce8a21469
    private Order order;
    private double finalPrice;
    private double price;
    private BQueue<Order> queue;
    private int elementNum;


<<<<<<< HEAD
    public OrderService(BQueue queue) {
        this.queue = queue;
    }

    public int getElementNum(){
        return elementNum;
    }

    public void addOrder() {
=======
    public synchronized void addOrder() {
>>>>>>> 07e86d7403182673e5ab76e238baf28ce8a21469
        order = new Order();
        elementNum++;
    }

<<<<<<< HEAD
    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
=======
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
>>>>>>> 07e86d7403182673e5ab76e238baf28ce8a21469
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

<<<<<<< HEAD
    public Order getOrder() {
        return order;
    }


    @Override
    public void run() {

        while (elementNum>0) {
            synchronized (queue) {
                System.out.println("Thread" + Thread.currentThread().getName() + "stuff");
            }
            if (queue.getSize() == queue.getLimit()) {
                System.out.println("Thread" + Thread.currentThread().getName() + "has left");
            }

            order = getOrder();
            queue.offer(order);
            --this.elementNum;

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
=======
    public void deliver() {
        delivery.addOrder(order);
        delivery.deliver();
    }

    public int checkStatus() {
        if (delivery.isDelivered()) {
            return 0;
        }
        return delivery.checkQueue(order);
>>>>>>> 07e86d7403182673e5ab76e238baf28ce8a21469
    }
}



