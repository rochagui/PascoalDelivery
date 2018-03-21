package org.academiadecodigo.hexallents.model;


public enum ItemType {

    SUPERBOCK(100),
    CRAFTBEER(120),
    SAGRES(80),
    FRITAS_LISAS_AMANHECER(100);


    int stock;

    ItemType(int stock) {

        this.stock = stock;
    }

    public synchronized int getStock() {

        return stock;
    }

    public synchronized void sell(int amount) {
        if (stock > 0) {
            stock -= amount;
        }
    }
}
