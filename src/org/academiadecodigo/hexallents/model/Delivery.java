package org.academiadecodigo.hexallents.model;

import org.academiadecodigo.hexallents.services.OrderService;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codecadet on 25/03/2018.
 */
public class Delivery {

    private boolean delivered;
    private final BQueue<Order> bqueue = new BQueue<>(2);
    private final int DELIVERYCAPACITY = 3;
    private final int DELIVERYTIME = 20000;
    private final Timer timer = new Timer();
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private OrderService orderService;
    private int element;



    public void deliver(Order order) {
        executorService.submit(new DeliverWorker(order));

    }

    public void deliveryOrder(Order order) {
        bqueue.offer(order);

    }

    public synchronized boolean isDelivered() {
        return delivered;
    }



    private class DeliverWorker implements Runnable {

        private Order order;

        public DeliverWorker(Order order) {
            this.order = order;
            element++;
            System.out.println(element);
        }

        @Override
        public void run() {

        }
    }
}
