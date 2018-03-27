package org.academiadecodigo.hexallents.model;

import java.util.LinkedList;

public class BQueue<Order> {
    final private int limit;

    final private LinkedList<Order> linkedList;


    public BQueue(int limit) {
        this.limit = limit;
        linkedList = new LinkedList<Order>();
    }


    public synchronized void offer(Order order) {

        while (getSize() >= limit) {
            try {
                System.out.println("order waiting...");
                wait(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            wait(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        linkedList.offer(order);
        System.out.println("element added, list is now " + getSize());

        notifyAll();

    }


    public synchronized Order poll() {

        while (linkedList.size() <= 0) {
            try {
                System.out.println("consumer waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        System.out.println("element removed list is now " + getSize());
        return linkedList.poll();
    }

    public synchronized int getSize() {
        return linkedList.size();
    }

    public int getLimit() {
        return limit;
    }
}
