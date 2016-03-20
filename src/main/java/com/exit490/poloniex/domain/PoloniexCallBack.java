package com.exit490.poloniex.domain;

public interface PoloniexCallBack<T> {

    void success(T response);

    void fail (String error);

}
