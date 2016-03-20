package com.exit490.poloniex.domain;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

public class PublicMethods {



    public void returnTicker(PoloniexCallBack<Map<String, Ticker>> poloniexCallBack) {
        PoloniexServiceRequest<Map<String, Ticker>> poloniexServiceRequest = new PoloniexServiceRequest(poloniexCallBack);
        Methods methods = poloniexServiceRequest.getConfiguration().create(Methods.class);
        Call<Map<String, Ticker>> tickerCall = methods.returnTicker();
        tickerCall.enqueue(poloniexServiceRequest.getCallback());
    }

    private interface Methods {

        @GET(Integration.URI_RETUR_TICKER)
        Call<Map<String, Ticker>> returnTicker();

    }


}
