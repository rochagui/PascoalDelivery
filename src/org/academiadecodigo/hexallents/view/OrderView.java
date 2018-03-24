package org.academiadecodigo.hexallents.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.ItemType;

public class OrderView extends AbstractView {

    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void show() {
        String[] options = ItemType.getItemNames();

        MenuInputScanner menuInputScanner = new MenuInputScanner(options);
        menuInputScanner.setMessage(Messages.CHOOSE_ITEM);

        int answerIndex = prompt.getUserInput(menuInputScanner);

        IntegerInputScanner inputScanner = new IntegerInputScanner();
        inputScanner.setMessage("How many " + ItemType.getItemNames()[answerIndex-1] +
                " do you want?");

        int amount = prompt.getUserInput(inputScanner);

        orderController.userOptionOrder(answerIndex-1,amount);

        show();

    }
}
