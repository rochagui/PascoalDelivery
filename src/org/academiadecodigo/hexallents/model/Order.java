package org.academiadecodigo.hexallents.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<ItemType, Integer> orderList;

    public Order() {
        orderList = new HashMap<>();
    }

    public void placeItem(int amount, ItemType itemType) {
        if (amount == 0) {
            return;
        }
        if (orderList.containsKey(itemType)) {
            orderList.put(itemType, orderList.get(itemType) + amount);
        }
        orderList.put(itemType, amount);
    }

    public void removeAmountItem(int amount, ItemType itemType) {
        if (amount == 0) {
            return;
        }
        if (orderList.containsKey(itemType) && orderList.get(itemType) > amount) {
            orderList.put(itemType, orderList.get(itemType) + amount);
        } else if (orderList.get(itemType) == amount) {
            removeItem(itemType);
        }
    }

    private void removeItem(ItemType itemType) {
        orderList.remove(itemType);
    }

    public Map<ItemType, Integer> getOrderList() {
        return orderList;
    }
}
