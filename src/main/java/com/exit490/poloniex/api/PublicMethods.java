package com.exit490.poloniex.api;

import com.exit490.poloniex.domain.OrderBook;
import com.exit490.poloniex.domain.Volume;
import com.exit490.poloniex.service.PoloniexCallBack;
import com.exit490.poloniex.service.PoloniexServiceRequest;
import com.exit490.poloniex.domain.Integration;
import com.exit490.poloniex.domain.Ticker;
import com.sun.xml.internal.bind.v2.TODO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public class PublicMethods {


    public void returnOrderBook(PoloniexCallBack<OrderBook> poloniexCallBack, String currencyPair, int depth) {
        PoloniexServiceRequest<OrderBook> poloniexServiceRequest = new PoloniexServiceRequest(poloniexCallBack);
        Methods methods = poloniexServiceRequest.getConfiguration().create(Methods.class);
        Call<OrderBook> orderBookCall = methods.returnOrderBook(currencyPair, depth);
        orderBookCall.enqueue(poloniexServiceRequest.getCallback());
    }

    //TODO: Find way to serialize this response
    public void return24hVolume(PoloniexCallBack<Volume> poloniexCallBack) {
        PoloniexServiceRequest<Volume> poloniexServiceRequest = new PoloniexServiceRequest(poloniexCallBack);
        Methods methods = poloniexServiceRequest.getConfiguration().create(Methods.class);
        Call<Volume> orderBookCall = methods.return24hVolume();
        orderBookCall.enqueue(poloniexServiceRequest.getCallback());
    }


    public void returnAllOrderBook(PoloniexCallBack<Map<String, OrderBook>> poloniexCallBack, int depth) {
        PoloniexServiceRequest<Map<String, OrderBook>> poloniexServiceRequest = new PoloniexServiceRequest(poloniexCallBack);
        Methods methods = poloniexServiceRequest.getConfiguration().create(Methods.class);
        Call<Map<String, OrderBook>> orderBookCall = methods.returnAllOrderBook("ALL", depth);
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
        Call<OrderBook> returnOrderBook(@Query("currencyPair") String currencyPair, @Query("depth") int depth);

        @GET(Integration.URI_RETURN_ORDER_BOOK)
        Call<Map<String, OrderBook>> returnAllOrderBook(@Query("currencyPair") String currencyPair, @Query("depth") int depth);

        @GET(Integration.URI_RETURN_24H_VOLUME)
        Call<Volume> return24hVolume();

    }


}
