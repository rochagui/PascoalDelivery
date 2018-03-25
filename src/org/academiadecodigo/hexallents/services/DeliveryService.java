package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.model.Order;

public class DeliveryService implements Runnable {

    private final BQueue<Order> queue;
    private OrderService orderService;
    private Order order;
    private int elementNumber;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
        this.elementNumber = orderService.getElementNum();
    }

    public DeliveryService(BQueue bQueue){
        this.queue = bQueue;
    }

    @Override
    public void run() {
        while (elementNumber>0){
            order = queue.poll();
            --this.elementNumber;
            System.out.println(elementNumber);
        }
    }
}