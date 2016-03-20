import com.exit490.poloniex.api.PublicMethods;
import com.exit490.poloniex.domain.OrderBook;
import com.exit490.poloniex.service.PoloniexCallBack;
import com.exit490.poloniex.domain.Ticker;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        PublicMethods publicMethods = new PublicMethods();
        publicMethods.returnOrderBook(new TikerCallBack(), "BTC_ETH", 50);



    }


    private static class TikerCallBack implements PoloniexCallBack<OrderBook> {

        @Override
        public void success(OrderBook response) {
            Gson gson = new Gson();
            String string = gson.toJson(response.getAsks());
            Logger logger = Logger.getLogger("HI");
            logger.info(string);

            PublicMethods publicMethods = new PublicMethods();
            publicMethods.returnOrderBook(new TikerCallBack(), "BTC_ETH", 50);

        }

        @Override
        public void fail(String error) {
            System.out.println(error);
        }
    }

    private static class MyThread extends TimerTask{

        public void run(){

        }

    }

}
