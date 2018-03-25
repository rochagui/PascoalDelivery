package org.academiadecodigo.hexallents.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import org.academiadecodigo.hexallents.controllers.MenuController;
import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.model.ItemType;

import java.io.PrintWriter;

public class OrderView extends AbstractView {

    private OrderController orderController;
    private PrintWriter printWriter;
    private String [] options;
    private MenuInputScanner menuInputScanner;
    private IntegerInputScanner integerInputScanner;
    private MenuController menuController;



    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public OrderView(){
        this.options = ItemType.getItemNames();
        this.menuInputScanner = new MenuInputScanner(options);
        this.integerInputScanner = new IntegerInputScanner();
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    @Override
    public void show() {

        menuInputScanner.setMessage(Messages.CHOOSE_ITEM);

        int answerIndex = prompt.getUserInput(menuInputScanner);


        integerInputScanner.setMessage("How many " + ItemType.getItemNames()[answerIndex - 1] +
                " do you want?");

        int amount = prompt.getUserInput(integerInputScanner);

        orderController.userOptionOrder(answerIndex - 1,amount);

        printWriter.println(orderController.orderList());


        if (answerIndex - 1 ==ItemType.BACK.ordinal() && answerIndex - 1 ==ItemType.CHECKOUT.ordinal()){
            menuController.init();
        }
        else {
            show();
        }


    }
}
