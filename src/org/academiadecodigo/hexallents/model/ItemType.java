package org.academiadecodigo.hexallents.model;


import org.academiadecodigo.hexallents.view.UserOptions;

public enum ItemType {

    SUPERBOCK("Superbock", 1.59),
    CRAFTBEER("CraftBeer", 3.50),
    SAGRES("Sagres", 1.30),
    FRITAS_LISAS_AMANHECER("Batatas Fritas Amanhecer", 0.8),
    CHECKOUT("Proceed to checkout",0),
    BACK("Back to main menu", 0);


    double price;
    String itemName;

    ItemType(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public double getPrice() {

        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public static String[] getItemNames() {

        String[] messages = new String[values().length];

        for (ItemType item : values()) {
            messages[item.ordinal()] = item.getItemName();
        }

        return messages;
    }

}
