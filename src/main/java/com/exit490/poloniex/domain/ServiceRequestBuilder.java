package com.exit490.poloniex.domain;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceRequestBuilder<ResponsePoloniex> {

    private String LOG_CONSTANT = ServiceRequestBuilder.class.getSimpleName();
    private Retrofit retrofit;
    private ResponseCallBack<ResponsePoloniex> callBackServiceBuilder;
    private Callback<ResponsePoloniex> callback;
    private OkHttpClient okHttpClient = new OkHttpClient();

    public ServiceRequestBuilder() {
        builderRetrofit();
    }

    private void builderRetrofit() {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.client(okHttpClient);
        retrofitBuilder
                .baseUrl("https://poloniex.com/")
                .addConverterFactory(GsonConverterFactory.create());
        retrofit = retrofitBuilder.build();
    }

//    public ServiceBuilder<ResponsePoloniex> addRequest(RequestZuum request) {
//        RequestHelper<RequestZuum> requestZuumRequestHelper = new RequestHelper<>(request, context);
//        request = requestZuumRequestHelper.getRequestZuum();
//        this.request = request;
//        Log.i(LOG_CONSTANT, "Request added : " + request.toString());
//        return this;
//    }

    public ServiceRequestBuilder<ResponsePoloniex> addCallBack(ResponseCallBack<ResponsePoloniex> callBackServiceBuilder) {
        this.callBackServiceBuilder = callBackServiceBuilder;
        callback = new BaseCallBack();
        return this;
    }

    private class BaseCallBack implements Callback<ResponsePoloniex> {
//        @Override
//        public void onResponse(Response<ResponsePoloniex> response, Retrofit retrofit) {
//            if (response.isSuccess()) {
//                Log.i(LOG_CONSTANT, "Response : "+ response.body().toString() +"");
//                selectFlowResponseSuccess(response.body());
//            } else {
//                Log.e(LOG_CONSTANT, "Error HTTP message:  " +  response.message() +  " Code: " + response.code());
//                buildError(new Throwable());
//            }
//        }
//
//        @Override
//        public void onFailure(Throwable throwable) {
//            Log.e(LOG_CONSTANT, "Error: " + throwable.getMessage() + "");
//            buildError(throwable);
//        }

        @Override
        public void onResponse(Call<ResponsePoloniex> call, Response<ResponsePoloniex> response) {
            if (response.isSuccessful()) {
                callBackServiceBuilder.success(response.body());
            } else {
                callBackServiceBuilder.fail(response.message());
            }
        }

        @Override
        public void onFailure(Call<ResponsePoloniex> call, Throwable t) {
            callBackServiceBuilder.fail(t.getMessage());
        }
    }

    public Retrofit getConfiguration() {
        return retrofit;
    }

//    private void selectFlowResponseSuccess(ResponseZuum responseZuum) {
//        //Log.i(LOG_CONSTANT, responseZuum.toString());
//        responseZuum.setFinancial(request.isFinancial());
//        if (responseZuum.getStatusResponse() == StatusResponse.SUCCESS) {
//            callBackServiceBuilder.success(responseZuum);
//        } else {
//            callBackServiceBuilder.fail(responseZuum);
//        }
//    }
//
//    private void configureHeaders() {
//        okHttpClient.interceptors().add(new ZuumInterceptors());
//    }


//    private void buildError(Throwable throwable) {
//
//    }
//
//
//
//
//    public abstract Class<ResponseZuum> getResponseZuumClazz();
//
//    public Retrofit getConfiguration() {
//        return retrofit;
//    }
//
//
    public Callback<ResponsePoloniex> getCallback() {
        return callback;
    }
//
//
//    protected RequestZuum getRequest() {
//        return request;
//    }
//
//
//    public abstract void execute();
}
