package com.karan.life_cycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name:EditText? =null
    var move:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        move =findViewById(R.id.move)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        move?.setOnClickListener {
            if(name?.text?.trim().isNullOrEmpty())
              name?.error="please fill the name"
                else{
            Toast.makeText(this, "Button is pressed", Toast.LENGTH_SHORT).show()
            var intent= Intent(this ,Life_cycle_secondscreen::class.java)
            startActivity(intent)
            finish()
            }
        }
    }
}