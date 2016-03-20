package com.exit490.poloniex.domain;

public interface Integration {

    String HOST = "https://poloniex.com/";
    String URI_RETURN_TICKER = "public?command=returnTicker";
    String URI_RETURN_24H_VOLUME = "public?command=return24hVolume";
    String URI_RETURN_ORDER_BOOK = "public?command=returnOrderBook";
}
