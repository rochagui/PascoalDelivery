package org.academiadecodigo.hexallents.model;

import java.util.LinkedList;

public class BQueue<T> {
    final private int limit;

    final private LinkedList<T> linkedList;


    public BQueue(int limit) {
        this.limit = limit;
        linkedList = new LinkedList<T>();
    }


    public synchronized void offer(T data) {

        while (getSize() >= limit) {
            try {
                System.out.println("order waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("element added, list is now " + getSize());
        linkedList.offer(data);
        notifyAll();

    }


    public synchronized T poll() {

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
