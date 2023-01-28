package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Find the button view
        val button = findViewById<Button>(R.id.go_to_next_activity_button)
        // Set the onClick listener for the button
        button.setOnClickListener {
            // Create an Intent to start the next activity
            val intent = Intent(this, StockPriceActivity::class.java)
            // Start the next activity
            startActivity(intent)
        }
    }
}