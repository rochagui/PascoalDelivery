package org.academiadecodigo.hexallents.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.hexallents.controllers.MenuController;


public class MenuView extends AbstractView {

    private Prompt prompt;
    private MenuController menuController;


    @Override
    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void show() {
        String[] options = UserOptions.getMessages();

        MenuInputScanner menuInputScanner = new MenuInputScanner(options);

        menuInputScanner.setMessage(Messages.WELCOME_MESSAGE);

        int answerIndex = prompt.getUserInput(menuInputScanner);

        menuController.onMenuSelection(answerIndex);

    }

}
