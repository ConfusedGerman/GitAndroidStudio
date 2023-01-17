package com.example.finalproject

import com.example.finalproject.NextActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button view
        val button = findViewById<Button>(R.id.go_to_next_activity_button)
        // Set the onClick listener for the button
        button.setOnClickListener {
            // Create an Intent to start the next activity
            val intent = Intent(this, NextActivity::class.java)
            // Start the next activity
            startActivity(intent)
        }
    }
}