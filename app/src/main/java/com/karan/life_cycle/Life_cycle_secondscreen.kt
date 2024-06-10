package com.karan.life_cycle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Life_cycle_secondscreen : AppCompatActivity() {
    var move2: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle_secondscreen)
        move2 = findViewById(R.id.move2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        move2?.setOnClickListener {

            Toast.makeText(this, "button 2 is pressed", Toast.LENGTH_SHORT).show()
            var intent=Intent(this,Life_cycle_thirdscreen::class.java)
            startActivity(intent)
            finish()
        }

    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "All operations resumed to previous", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, " stop the operations", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "all the activities are resumed", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "the process is destroyed", Toast.LENGTH_SHORT).show()
    }
}