package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.services.OrderService;

public class CheckStatusController extends AbstractController {

    private OrderService orderService;
    private OrderController orderController;
    private MenuController menuController;

    @Override
    public void init() {
        if (orderService.getOrder() == null) {
            menuController.init();
        }
        super.init();
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public String showStatus() {
        return orderController.getOrderList();
    }
}

