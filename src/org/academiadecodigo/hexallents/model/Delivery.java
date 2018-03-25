package org.academiadecodigo.hexallents.model;

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
    private final Queue<Order> queue;
    private final int DELIVERYCAPACITY = 3;
    private final int DELIVERYTIME = 20000;
    private final Timer timer = new Timer();
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private DeliverWorker deliverWorker;

    public Delivery() {
        queue = new ConcurrentLinkedQueue<>();

    }

    public void deliver() {
        executorService.submit(deliverWorker);
    }

    public void addOrder(Order order) {
        queue.add(order);
    }

    public synchronized boolean isDelivered() {
        return delivered;
    }

    public synchronized int checkQueue(Order orderCheck) {
        int counter = 0;
        for (Order order : queue) {
            if (orderCheck != order) {
                counter++;
            }
        }
        return counter;
    }

    private class DeliverWorker implements Runnable {

        private Order order;

        public DeliverWorker(Order order) {
            this.order = order;
        }

        @Override
        public void run() {

        }
    }
}
