package com.example.ecommerceproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.ecommerceproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val handler = Handler()
        handler.postDelayed( {
            val intent = Intent(this,LoginRegisterActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}