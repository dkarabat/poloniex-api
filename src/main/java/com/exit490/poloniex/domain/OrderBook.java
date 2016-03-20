package com.exit490.poloniex.domain;

import java.math.BigDecimal;
import java.util.List;

public class OrderBook {

    private List<List<BigDecimal>> asks;

    public List<List<BigDecimal>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<BigDecimal>> asks) {
        this.asks = asks;
    }
}
