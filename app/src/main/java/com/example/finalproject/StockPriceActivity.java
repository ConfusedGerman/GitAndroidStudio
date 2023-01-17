package com.example.finalproject;

import android.os.Bundle;
import android.widget.TextView;

import com.loopj.android.http.*;

import androidx.appcompat.app.AppCompatActivity;

import cz.msebera.android.httpclient.Header;


public class StockPriceActivity extends AppCompatActivity {

    private TextView mStockPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_price);

        mStockPriceTextView = findViewById(R.id.stock_price_text_view);

        // Initialize the HTTP client
        AsyncHttpClient client = new AsyncHttpClient();

        // Set the API key
        String apiKey = getString(R.string.alpha_vantage_api_key);
        //String stockSymbol = editStockSymbol.getText(); HEUDJSJHUIFHSJFIOSJFIOSFJIOSJIFSOJFSI
        // Set the URL for the API request
        String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=AAPL&apikey=" + apiKey;

        // Make the request
        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // The request was successful. You can parse the response body to get the stock price.
                String response = new String(responseBody);
                // Parse the JSON response to get the stock price
                String stockPrice = StockPriceParser.parseStockPriceFromJSON(response);
                // Update the TextView with the stock price
                mStockPriceTextView.setText(stockPrice);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // The request failed. You can handle the error here.
            }
        });
    }
}

