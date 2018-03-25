package org.academiadecodigo.hexallents.services;

import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by codecadet on 25/03/2018.
 */
public class BQueue<T> {

    final private int limit;

    final private LinkedList<T> linkedList;


    public BQueue(int limit) {
        this.limit = limit;
        linkedList = new LinkedList<>();
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

