package org.academiadecodigo.hexallents;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.hexallents.Server.ServerWorker;
import org.academiadecodigo.hexallents.controllers.CheckStatusController;
import org.academiadecodigo.hexallents.controllers.Controller;
import org.academiadecodigo.hexallents.controllers.MenuController;
import org.academiadecodigo.hexallents.controllers.OrderController;
import org.academiadecodigo.hexallents.services.OrderService;
import org.academiadecodigo.hexallents.view.MenuView;
import org.academiadecodigo.hexallents.view.OrderView;
import org.academiadecodigo.hexallents.view.UserOptions;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class BootStrap {
    private ServerWorker serverWorker;

    public void setServerWorker(ServerWorker serverWorker) {
        this.serverWorker = serverWorker;
    }

    public Controller wireObjects() {


        Prompt prompt = new Prompt(serverWorker.getInputStream(), serverWorker.getPrintStream());
        PrintWriter printWriter = new PrintWriter(serverWorker.getPrintStream(), true);
        MenuController menuController = new MenuController();
        MenuView menuView = new MenuView();
        OrderController orderController = new OrderController();
        OrderView orderView = new OrderView();

        OrderService orderService = new OrderService();
        CheckStatusController checkStatusController = new CheckStatusController();


        menuController.setView(menuView);

        menuView.setMenuController(menuController);
        menuView.setPrompt(prompt);

        orderController.setView(orderView);
        orderController.setOrderService(orderService);
        orderController.setMenuController(menuController);
        orderService.setOrderController(orderController);
        orderView.setPrompt(prompt);
        orderView.setPrintWriter(printWriter);
        orderView.setOrderController(orderController);

        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.MAKE_ORDER.getAnswerIndex(), orderController);
        controllerMap.put(UserOptions.CHECK_STATUS.getAnswerIndex(), checkStatusController);


        menuController.setMap(controllerMap);

        return menuController;

    }
}
