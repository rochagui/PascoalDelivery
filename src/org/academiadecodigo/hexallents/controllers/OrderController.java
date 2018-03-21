package org.academiadecodigo.hexallents.controllers;

import org.academiadecodigo.hexallents.services.OrderService;
import org.academiadecodigo.hexallents.view.OrderView;

public class OrderController implements Controller {

    private OrderView orderView;
    private OrderService orderService;


    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setOrderView(OrderView orderView) {
        this.orderView = orderView;
    }

    @Override
    public void init() {
        orderService.addOrder();
    }
}
