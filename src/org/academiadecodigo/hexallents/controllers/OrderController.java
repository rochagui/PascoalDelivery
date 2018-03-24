package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.model.ItemType;
import org.academiadecodigo.hexallents.services.OrderService;

public class OrderController extends AbstractController {

    private OrderService orderService;
    private MenuController menuController;



    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void userOptionOrder(int answerIndex, int amount) {
        init();
        orderService.addOrder();
        if(answerIndex == ItemType.BACK.ordinal()+1){
            menuController.init();
        }
        orderService.placeItem(amount, ItemType.values()[answerIndex-1]);

    }
}
