package com.exit490.poloniex.api;

import com.exit490.poloniex.domain.OrderBook;
import com.exit490.poloniex.service.PoloniexCallBack;
import com.exit490.poloniex.service.PoloniexServiceRequest;
import com.exit490.poloniex.domain.Integration;
import com.exit490.poloniex.domain.Ticker;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Map;

public class PublicMethods {

    public void returnOrderBook(PoloniexCallBack<OrderBook> poloniexCallBack, String currencyPair, int depth){
        PoloniexServiceRequest<OrderBook> poloniexServiceRequest = new PoloniexServiceRequest(poloniexCallBack);
        Methods methods = poloniexServiceRequest.getConfiguration().create(Methods.class);
        Call<OrderBook> orderBookCall = methods.returnOrderBook(currencyPair,depth);
        orderBookCall.enqueue(poloniexServiceRequest.getCallback());
    }

    public void returnTicker(PoloniexCallBack<Map<String, Ticker>> poloniexCallBack) {
        PoloniexServiceRequest<Map<String, Ticker>> poloniexServiceRequest = new PoloniexServiceRequest(poloniexCallBack);
        Methods methods = poloniexServiceRequest.getConfiguration().create(Methods.class);
        Call<Map<String, Ticker>> tickerCall = methods.returnTicker();
        tickerCall.enqueue(poloniexServiceRequest.getCallback());
    }

    private interface Methods {

        @GET(Integration.URI_RETURN_TICKER)
        Call<Map<String, Ticker>> returnTicker();

        @GET(Integration.URI_RETURN_ORDER_BOOK)
        Call<OrderBook> returnOrderBook(@Query("currencyPair") String currencyPair,@Query("depth") int depth);

    }


}
