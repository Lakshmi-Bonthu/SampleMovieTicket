package com.example.login

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        welcomeTextView = findViewById(R.id.welcomeTextView)

        // Retrieve username from the Intent
        val username = intent.getStringExtra("USERNAME")

        // Set welcome message with the username
        welcomeTextView.text = "Welcome, $username!"
    }
}