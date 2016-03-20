package com.exit490.poloniex.domain;

import java.util.List;

public class LoanOrders {

    private List<LoanOrder> offers;
    private List<LoanOrder> demands;

    public List<LoanOrder> getOffers() {
        return offers;
    }

    public void setOffers(List<LoanOrder> offers) {
        this.offers = offers;
    }

    public List<LoanOrder> getDemands() {
        return demands;
    }

    public void setDemands(List<LoanOrder> demands) {
        this.demands = demands;
    }
}
