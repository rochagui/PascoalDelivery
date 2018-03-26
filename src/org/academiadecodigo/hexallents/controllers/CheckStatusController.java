package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.services.OrderService;

public class CheckStatusController extends AbstractController {

    private OrderService orderService;
    private MenuController menuController;

    @Override
    public void init() {
        menuController.init();
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

}

