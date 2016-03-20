import com.exit490.poloniex.api.PublicMethods;
import com.exit490.poloniex.domain.*;
import com.exit490.poloniex.service.PoloniexCallBack;
import com.google.gson.Gson;

import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        PublicMethods publicMethods = new PublicMethods();
        publicMethods.returnLoanOrders(new TestsCallBack(), "BTC");



    }


    private static class TestsCallBack implements PoloniexCallBack<LoanOrders> {

        @Override
        public void success(LoanOrders response) {
            Gson gson = new Gson();
            String string = gson.toJson(response);
            Logger logger = Logger.getLogger("HI");
            logger.info(string);

            PublicMethods publicMethods = new PublicMethods();
            publicMethods.returnLoanOrders(new TestsCallBack(), "BTC");

        }

        @Override
        public void fail(String error) {
            System.out.println(error);
        }
    }

}
