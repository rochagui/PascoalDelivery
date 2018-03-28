package org.academiadecodigo.hexallents.model;

import org.academiadecodigo.hexallents.services.OrderService;

import java.util.TimerTask;

/**
 * Created by codecadet on 25/03/2018.
 */
public class Delivery {

    private final BQueue<Order> bqueue = new BQueue<>();
    private OrderService orderService;
    private String waitingTime = "Your order has been dispatched!";



    public void beginOrder(Order order) {
        bqueue.setClock(new Clock());
        bqueue.offer(order);

    }

    public String getWaitingTime() {
        return waitingTime;
    }


    public boolean isDelivered(){
        return bqueue.isDelivered();
    }

    public boolean isDispatched() {
        return bqueue.isDispatched();
    }

    private class Clock extends TimerTask {

        private int counter = 10;

        @Override
        public void run() {
            waitingTime =  "You have to wait " + counter + " minutes...";
            counter--;
            System.out.println(waitingTime);
            if (counter == 0) {
                bqueue.setDelivered(true);
                cancel();
            }

        }



    }

}


