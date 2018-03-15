package org.academiadecodigo.hexallents.model;

import org.academiadecodigo.hexallents.Controller;

public enum ItemType implements Controller{

    SUPERBOCK(100) {
        @Override
        public void init() {

        }
    },
    CRAFTBEER(120) {
        @Override
        public void init() {

        }
    },
    SAGRES(80) {
        @Override
        public void init() {

        }
    },
    FRITAS_LISAS_AMANHECER(100) {
        @Override
        public void init() {

        }
    };


    int stock;

    ItemType(int stock) {

        this.stock = stock;
    }

    public synchronized int getStock() {

        return stock;
    }

    public synchronized int sell(int amount) {
        if (stock > 0) {
            stock -= amount;
            return stock;
        }
        return -1;
    }
}
