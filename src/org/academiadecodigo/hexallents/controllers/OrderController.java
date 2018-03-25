package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.model.ItemType;
import org.academiadecodigo.hexallents.services.OrderService;

import java.io.PrintWriter;

public class OrderController extends AbstractController {

    private OrderService orderService;
    private MenuController menuController;
    private String orderList;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void init() {
        orderService.addOrder();
        super.init();
    }

    public void userOptionOrder(int answerIndex, int amount) {
        orderService.buy(ItemType.values()[answerIndex], amount);
        orderList = orderService.orderList(amount);
    }

    public String getOrderList() {

        return orderList;
    }


}
