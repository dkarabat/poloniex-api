package com.exit490.poloniex.service;

public interface PoloniexCallBack<T> {

    void success(T response);

    void fail (String error);

}
