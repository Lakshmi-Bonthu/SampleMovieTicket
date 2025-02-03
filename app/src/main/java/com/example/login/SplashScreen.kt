package com.example.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)


            val splashScreenDuration = 3000L

            Handler(Looper.getMainLooper()).postDelayed({
                // Start the main activity after the splash screen
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, splashScreenDuration)
        }
    }
