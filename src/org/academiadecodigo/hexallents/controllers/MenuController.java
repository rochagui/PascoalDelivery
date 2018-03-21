package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.view.MenuView;
import org.academiadecodigo.hexallents.model.ItemType;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class MenuController extends AbstractController {

    private MenuView menuView;
    private Map<Integer,Controller> map = new HashMap<>();

    public MenuController(InputStream input, PrintStream out){
        menuView = new MenuView(input, out,this);
    }
    @Override
    public void init() {

    }

    public void mainMenu(int answerIndex) {
    }

    public void setMap() {
        map.put(1,ItemType.SUPERBOCK);
    }
}