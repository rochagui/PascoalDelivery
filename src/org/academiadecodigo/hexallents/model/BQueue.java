package org.academiadecodigo.hexallents.model;

import java.time.Clock;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class BQueue<Order> {
    private final int LIMIT = 3;
    private boolean delivered = false;
    private boolean dispatched = false;
    private final LinkedList<Order> linkedList;
    private Timer timer;
    private TimerTask timerTask;

    public BQueue() {

        linkedList = new LinkedList<>();
        timer = new Timer();
    }


    public synchronized void offer(Order order) {
        while (getSize() >= LIMIT) {
            try {
                System.out.println("order waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        linkedList.offer(order);
        dispatched = true;
        System.out.println("element added, list is now " + getSize());
        poll();

    }

    public void setClock(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    private synchronized void poll() {

        while (linkedList.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
        notifyAll();
        if (delivered) {
            linkedList.poll();
            delivered = false;
        }
        System.out.println("element removed list is now " + getSize());
    }

    public synchronized int getSize() {
        return linkedList.size();
    }

    public synchronized boolean isDispatched() {
        return dispatched;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public int getLimit() {
        return LIMIT;
    }


    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
