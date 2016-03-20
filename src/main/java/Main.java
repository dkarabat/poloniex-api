import com.exit490.poloniex.api.PublicMethods;
import com.exit490.poloniex.domain.*;
import com.exit490.poloniex.service.PoloniexCallBack;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        PublicMethods publicMethods = new PublicMethods();
        publicMethods.returnChartData(new TikerCallBack(), "BTC_NXT", "1410158341", "1410499372", "14400" );



    }


    private static class TikerCallBack implements PoloniexCallBack<List<ChartData>> {

        @Override
        public void success(List<ChartData> response) {
            Gson gson = new Gson();
            String string = gson.toJson(response);
            Logger logger = Logger.getLogger("HI");
            logger.info(string);

            PublicMethods publicMethods = new PublicMethods();
            publicMethods.returnChartData(new TikerCallBack(), "BTC_XMR", "1405699200", "9999999999", "14400" );

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
