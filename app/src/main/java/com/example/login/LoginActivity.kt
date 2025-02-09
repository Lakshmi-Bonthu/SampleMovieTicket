package com.example.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tv_Register: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtName = findViewById(R.id.edtName)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tv_Register = findViewById(R.id.tv_Register)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val name = edtName.text.toString()
            val password = edtPassword.text.toString()

            if (validateLogin(name, password)) {
                // Save login state
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                // Go to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()  // To prevent going back to the login page
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        tv_Register.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateLogin(name: String, password: String): Boolean {
        val savedName = sharedPreferences.getString("name", "")
        val savedPassword = sharedPreferences.getString("password", "")

        return name == savedName && password == savedPassword
    }
}
