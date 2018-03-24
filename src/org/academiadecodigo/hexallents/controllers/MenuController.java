package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.view.MenuView;
import org.academiadecodigo.hexallents.view.Messages;
import org.academiadecodigo.hexallents.view.UserOptions;

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

    public void onMenuSelection(int option) {

        if (option == UserOptions.QUIT.getOption()) {
            return;
        }

        if (!map.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        controllerMap.get(option).init();
        init();
    }
}
}
