package org.academiadecodigo.hexallents;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by codecadet on 13/03/2018.
 */
public class ClientInterface {
    public Prompt prompt;
    public MenuInputScanner menuInputScanner;


    public ClientInterface(InputStream input, PrintStream out){
        prompt = new Prompt(input, out);
    }
    public void init() {
        String[] options = {"Make your request", "Check status"};
        menuInputScanner = new MenuInputScanner(options);
        menuInputScanner.setMessage("Register or Login?");
        int answerIndex = prompt.getUserInput(menuInputScanner);
        if (answerIndex - 1 == 0) {
            System.out.println("Request being made");
        } else if (answerIndex - 1 == 1) {
            System.out.println("Checking order status");
        }
    }
}

