package principal;

import client.HttpClient;
import model.CurrencyEnum;

import java.io.IOException;

public class Conversor {
    Double getConversionRate(CurrencyEnum incomming, CurrencyEnum converted, Double value) throws IOException {
        HttpClient client = new HttpClient();
        Double conversorRate = client.getConverter(incomming, converted);
        return value * conversorRate;
    }


}
