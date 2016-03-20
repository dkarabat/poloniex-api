package com.exit490.poloniex.domain;

public interface ResponseCallBack<T> {

    void success(T response);

    void fail (String error);

}
