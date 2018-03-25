package org.academiadecodigo.hexallents.model;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by codecadet on 25/03/2018.
 */
public class Delivery implements Runnable{

    private Queue<Order> queue;

    public Delivery() {
        queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void run() {

    }

    public void addOrder(Order order){
        queue.add(order);
        System.out.println("addedOrder");
    }
}
