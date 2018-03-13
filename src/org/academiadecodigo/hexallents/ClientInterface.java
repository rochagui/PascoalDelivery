package org.academiadecodigo.hexallents;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;


import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by codecadet on 13/03/2018.
 */
public class ClientInterface {
    private Prompt prompt;
    private MenuInputScanner menuInputScanner;
    private Courier courier;
    private Beer beer;


    public ClientInterface(InputStream input, PrintStream out){
        prompt = new Prompt(input, out);
    }
    public void init() {
        String[] options = {"Superbock", "CraftBeer"};
        menuInputScanner = new MenuInputScanner(options);
        menuInputScanner.setMessage("Register or Login?");
        int answerIndex = prompt.getUserInput(menuInputScanner);
        switch (answerIndex){
            case 0:
                orderBeer(Beer.SUPERBOCK);
                System.out.println(Beer.SUPERBOCK.getPrice());
                break;
            case 1:
                orderBeer(Beer.CRAFTBEER);
                System.out.println(Beer.CRAFTBEER.getPrice());
        }
    }

    public void orderBeer(Beer askedBeer){
        courier = new Courier();
        this.beer = courier.getBeer(askedBeer);
    }
}

