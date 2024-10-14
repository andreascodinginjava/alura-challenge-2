package client;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.CurrencyEnum;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static model.ConverterConstants.API_KEY;

public class HttpClient {

    public Double getConverter(CurrencyEnum incomming, CurrencyEnum converted) throws IOException {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + incomming.name();
        URL url = new URL(urlStr);

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonObj = root.getAsJsonObject();

        return Double.parseDouble(jsonObj.get("conversion_rates").getAsJsonObject().get(converted.name()).getAsString());
    }

}
