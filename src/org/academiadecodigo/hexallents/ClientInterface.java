package org.academiadecodigo.hexallents;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;


import java.io.*;

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
        switch (answerIndex -1){
            case 0:
                orderBeer(Beer.SUPERBOCK);
                break;
            case 1:
                orderBeer(Beer.CRAFTBEER);
        }

    }

    public Beer orderBeer(Beer askedBeer){
        courier = new Courier();
        return this.beer = courier.getBeer(askedBeer);
    }

    public int showPrice(){
        return orderBeer(this.beer).getPrice();
    }
}

