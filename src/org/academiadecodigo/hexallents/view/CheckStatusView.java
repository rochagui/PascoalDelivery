package org.academiadecodigo.hexallents.view;

import org.academiadecodigo.hexallents.controllers.CheckStatusController;
import org.academiadecodigo.hexallents.controllers.MenuController;
import org.academiadecodigo.hexallents.model.Delivery;

import java.io.PrintWriter;

public class CheckStatusView extends AbstractView{

    private CheckStatusController checkStatusController;
    private MenuController menuController;
    private PrintWriter printWriter;

    public void setCheckStatusController(CheckStatusController checkStatusController) {
        this.checkStatusController = checkStatusController;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void show() {
        printWriter.println(checkStatusController.showStatus());
        while (!checkStatusController.isDelivered() && checkStatusController.isDispatched()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printWriter.println(checkStatusController.getDeliveryFeedback());
        }
        menuController.init();
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
}
