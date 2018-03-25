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

    public synchronized String showStatus() {
        int queue = orderService.checkStatus();

        if(queue == 0){
            return "You´re next in the line";
        } else if(queue == 0){

        }
        return "Your order is on the queue. \n Your position in queue:\t" + orderService.checkStatus();
    }
}
