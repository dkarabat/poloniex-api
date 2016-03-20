package com.exit490.poloniex.domain;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

public class MethodsPublic {



    public void returnTicker(ResponseCallBack<Map<String, Ticker>> responseCallBack) {


        ServiceRequestBuilder<Map<String, Ticker>> serviceRequestBuilder = new ServiceRequestBuilder();
        serviceRequestBuilder.addCallBack(responseCallBack);

        PublicMethods publicMethods = serviceRequestBuilder.getConfiguration().create(PublicMethods.class);
        Call<Map<String, Ticker>> tickerCall = publicMethods.returnTicker();
        tickerCall.enqueue(serviceRequestBuilder.getCallback());
    }

    private interface PublicMethods {

        @GET("public?command=returnTicker")
        Call<Map<String, Ticker>> returnTicker();

    }


}
