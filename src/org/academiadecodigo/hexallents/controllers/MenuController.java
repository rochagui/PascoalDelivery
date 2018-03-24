package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.view.Messages;
import org.academiadecodigo.hexallents.view.UserOptions;

import java.util.Map;

public class MenuController extends AbstractController {

    private Map<Integer, Controller> map;

    public void setMap(Map<Integer, Controller> map) {
        this.map = map;
    }


    public void onMenuSelection(int option) {

        if (option == UserOptions.QUIT.getAnswerIndex()) {
            return;
        }

        if (!map.containsKey(option)) {
            throw new IllegalStateException(Messages.SYSTEM_ERROR);
        }

        map.get(option).init();
    }

}
