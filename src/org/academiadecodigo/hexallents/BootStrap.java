package org.academiadecodigo.hexallents;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.hexallents.Server.ServerWorker;
import org.academiadecodigo.hexallents.controllers.CheckStatusController;
import org.academiadecodigo.hexallents.controllers.Controller;
import org.academiadecodigo.hexallents.controllers.MenuController;
import org.academiadecodigo.hexallents.controllers.OrderController;

import org.academiadecodigo.hexallents.model.Order;
import org.academiadecodigo.hexallents.services.BQueue;
import org.academiadecodigo.hexallents.services.DeliveryService;

import org.academiadecodigo.hexallents.services.OrderService;
import org.academiadecodigo.hexallents.view.CheckStatusView;
import org.academiadecodigo.hexallents.view.MenuView;
import org.academiadecodigo.hexallents.view.OrderView;
import org.academiadecodigo.hexallents.view.UserOptions;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class
BootStrap {
    private ServerWorker serverWorker;
    private Socket socket;
    private OrderService orderService;

    public void setServerWorker(ServerWorker serverWorker) {
        this.serverWorker = serverWorker;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Controller wireObjects() {


        Prompt prompt = new Prompt(serverWorker.getInputStream(), serverWorker.getPrintStream());
        PrintWriter printWriter = new PrintWriter(serverWorker.getPrintStream(), true);
        MenuController menuController = new MenuController();
        MenuView menuView = new MenuView();
        OrderController orderController = new OrderController();
        OrderView orderView = new OrderView();
        orderView.setMenuController(menuController);

        BQueue<Order> queue = new BQueue<>(3);
        orderService = new OrderService(queue);
        CheckStatusController checkStatusController = new CheckStatusController();
        DeliveryService deliveryService = new DeliveryService(queue);
        deliveryService.setOrderService(orderService);

        Thread thread = new Thread(orderService);
        Thread thread1 = new Thread(deliveryService);
        thread.start();
        thread1.start();
        OrderService orderService = new OrderService(queue);
        CheckStatusView checkStatusView = new CheckStatusView();
        checkStatusView.setCheckStatusController(checkStatusController);
        checkStatusView.setPrintWriter(printWriter);
        checkStatusController.setOrderService(orderService);
        checkStatusController.setMenuController(menuController);
        checkStatusController.setView(checkStatusView);
        checkStatusView.setMenuController(menuController);

        menuController.setView(menuView);
        menuView.setMenuController(menuController);
        menuView.setPrompt(prompt);
        orderController.setView(orderView);
        orderController.setOrderService(orderService);
        orderController.setMenuController(menuController);
        orderView.setPrompt(prompt);
        orderView.setPrintWriter(printWriter);
        orderView.setOrderController(orderController);
        orderView.setCheckStatusController(checkStatusController);

        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.MAKE_ORDER.getAnswerIndex(), orderController);
        controllerMap.put(UserOptions.CHECK_STATUS.getAnswerIndex(), checkStatusController);


        menuController.setMap(controllerMap);

        return menuController;

    }
}
