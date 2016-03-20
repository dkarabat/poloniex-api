import com.exit490.poloniex.api.PublicMethods;
import com.exit490.poloniex.domain.OrderBook;
import com.exit490.poloniex.domain.Volume;
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
        publicMethods.return24hVolume(new TikerCallBack());



    }


    private static class TikerCallBack implements PoloniexCallBack<Volume> {

        @Override
        public void success(Volume response) {
            Gson gson = new Gson();
            String string = gson.toJson(response);
            Logger logger = Logger.getLogger("HI");
            logger.info(string);

            PublicMethods publicMethods = new PublicMethods();
            publicMethods.return24hVolume(new TikerCallBack());

        }

        @Override
        public void fail(String error) {
            error = error;
            System.out.println(error);
        }
    }

    private static class MyThread extends TimerTask{

        public void run(){

        }

    }

}
