package com.example.finalproject;

import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


public class StockPriceParser {

    public static String parseStockPriceFromJSON(String json) {
        try {
            // Parse the JSON string to get the stock price
            JSONObject jsonObject = new JSONObject(json);
            JSONObject quote = jsonObject.getJSONObject("Global Quote");
            String price = quote.getString("05. price");
            return price;
        } catch (JSONException e) {
            // There was an error parsing the JSON.
            System.exit(1);
            return null;
        }
    }

}

