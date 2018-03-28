package org.academiadecodigo.hexallents.model;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<ItemType, Double> orderList;
    private ItemType itemType;

    public Order() {
        orderList = new HashMap<>();
    }

    public void placeItem(ItemType itemType) {
        orderList.putIfAbsent(itemType, itemType.getPrice());
    }

    public double buy(ItemType itemType, int amount){
        placeItem(itemType);
        return orderList.get(itemType)*amount;
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

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    private void removeItem(ItemType itemType) {
        orderList.remove(itemType);
    }

    public Map<ItemType, Double> getOrderList() {
        return orderList;
    }

    public boolean isEmpty() {
        return orderList.isEmpty();
    }
}
