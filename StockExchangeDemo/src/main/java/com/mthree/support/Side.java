package com.mthree.support;

public enum Side {
    BUY, SELL;
    public Side opposite;

    static {
        BUY.opposite = SELL;
        SELL.opposite = BUY;
    }

    public Side getOppositeSide() {
        return opposite;
    }
}
