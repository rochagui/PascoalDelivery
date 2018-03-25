package org.academiadecodigo.hexallents.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.hexallents.controllers.CheckStatusController;
import org.academiadecodigo.hexallents.controllers.MenuController;
import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.ItemType;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderView extends AbstractView {

    private OrderController orderController;
    private PrintWriter printWriter;
    private CheckStatusController checkStatusController;

    private MenuController menuController;

    private MenuView menuView;

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setCheckStatusController(CheckStatusController checkStatusController) {
        this.checkStatusController = checkStatusController;
    }

    @Override
    public void show() {
        ArrayList<String> list = new ArrayList(Arrays.asList(ItemType.getItemNames()));

        list.addAll(Arrays.asList(LeaveOptions.leaveOptions()));

        String[] options = Arrays.copyOf(list.toArray(), list.toArray().length, String[].class);

        MenuInputScanner menuInputScanner = new MenuInputScanner(options);

        menuInputScanner.setMessage(Messages.CHOOSE_ITEM);

        int answerIndex = prompt.getUserInput(menuInputScanner);

        IntegerInputScanner integerInputScanner = new IntegerInputScanner();

        if (answerIndex == LeaveOptions.BACK.getUserOptions()) {
            menuController.init();
            show();
        }

        if (answerIndex == LeaveOptions.CHECKOUT.getUserOptions()){
            printWriter.println(orderController.getOrderList());
            checkStatusController.init();
        }

        if (options[answerIndex - 1] == ItemType.getItemNames()[answerIndex - 1]) {

            integerInputScanner.setMessage("How many " + ItemType.getItemNames()[answerIndex - 1] +
                    " do you want?");

            int amount = prompt.getUserInput(integerInputScanner);

            orderController.userOptionOrder(answerIndex - 1, amount);
            show();
        }
    }
}




