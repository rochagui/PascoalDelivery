package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.services.OrderService;

public class CheckStatusController extends AbstractController {

    private OrderService orderService;
    private OrderController orderController;
    private MenuController menuController;

    @Override
    public void init() {
        if (orderService.getOrder() == null || orderService.getOrder().isEmpty()) {
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

    public String getDeliveryFeedback(){
        return orderService.getDelivery().getWaitingTime();
    }

    public boolean isDelivered(){
        return orderService.isDelivered();
    }

    public boolean isDispatched() {
        return orderService.isDispatched();
    }
}

