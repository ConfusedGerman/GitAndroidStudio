package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.loopj.android.http.*;
import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;
import android.widget.EditText;
import android.widget.Button;

public class StockPriceActivity extends AppCompatActivity {

    private EditText mStockPriceEditText;
    private TextView mStockPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_price);

        mStockPriceEditText = findViewById(R.id.stock_price_edit_text);
        mStockPriceTextView = findViewById(R.id.stock_price_text_view);

        Button button = findViewById(R.id.button2);

        button.setOnClickListener((view) -> {
            // Initialize the HTTP client
            AsyncHttpClient client = new AsyncHttpClient();

            // Set the API key
            String apiKey = getString(R.string.alpha_vantage_api_key);

            if (view.getId() == R.id.button2) {
                String stockSymbol = mStockPriceEditText.getText().toString();
                // Set the URL for the API request
                String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockSymbol + "&apikey=" + apiKey;
                // Make the request
                client.get(url, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        // The request was successful.
                        String response = new String(responseBody);
                        // Parse the JSON response to get the stock price
                        String stockPrice = StockPriceParser.parseStockPriceFromJSON(response);
                        // Update the TextView with the stock price
                        mStockPriceTextView.setText(stockPrice);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        // The request failed. Handle the error.
                        Log.d("ErrorClass", "Everything went wrong when you see this!"); //TODO
                    }
                });
            }
        });
    }
}


