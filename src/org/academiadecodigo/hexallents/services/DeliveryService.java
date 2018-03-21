package org.academiadecodigo.hexallents.services;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryService extends AbstractService {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private Timer timer;


    public String deliver(){
        try {
            wait(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }


}
