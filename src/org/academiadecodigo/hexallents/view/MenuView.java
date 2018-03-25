package org.academiadecodigo.hexallents.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.hexallents.controllers.MenuController;


public class MenuView extends AbstractView {

    private Prompt prompt;
    private MenuController menuController;
    private MenuInputScanner menuInputScanner1;


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

        menuInputScanner1 = new MenuInputScanner(options);
        menuInputScanner1.setMessage(Messages.WELCOME_MESSAGE);

        int answerIndex = prompt.getUserInput(menuInputScanner1);

        menuController.onMenuSelection(answerIndex);

    }

}
