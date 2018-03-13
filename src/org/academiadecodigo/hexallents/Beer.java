package org.academiadecodigo.hexallents;

/**
 * Created by codecadet on 13/03/2018.
 */
public enum Beer {
    SUPERBOCK(2),
    CRAFTBEER(5);

    private int price;

    Beer(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

