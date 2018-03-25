package org.academiadecodigo.hexallents.services;

import org.academiadecodigo.hexallents.model.Delivery;
import org.academiadecodigo.hexallents.model.Order;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryService {

    private Delivery delivery;
    private OrderService orderService;

    public DeliveryService(){
        this.delivery = new Delivery();
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    //private ExecutorService executorService = Executors.newFixedThreadPool(3);



    /*public String deliver(){
        try {
            wait(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }*/


    public void addOrder(Order order){
        delivery.addOrder(order);
        System.out.println("please workg");
    }

}
