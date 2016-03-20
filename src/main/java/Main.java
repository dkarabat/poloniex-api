import com.exit490.poloniex.domain.MethodsPublic;
import com.exit490.poloniex.domain.ResponseCallBack;
import com.exit490.poloniex.domain.Ticker;
import com.google.gson.Gson;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        MethodsPublic methodsPublic = new MethodsPublic();
        methodsPublic.returnTicker(new TikerCallBack());



    }


    private static class TikerCallBack implements ResponseCallBack<Map<String,Ticker>>{

        @Override
        public void success(Map<String, Ticker> response) {
            Gson gson = new Gson();
            Ticker ticker = response.get("BTC_ETH");
            String string = gson.toJson(ticker);
            Logger logger = Logger.getLogger("HI");
            logger.info(string);

            MethodsPublic methodsPublic = new MethodsPublic();
            methodsPublic.returnTicker(new TikerCallBack());

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
