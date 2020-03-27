package com.kotlin.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val singleplayer =findViewById<Button>(R.id.singleplayer)
        val multiplayer=findViewById<Button>(R.id.multiplayer)

        singleplayer.setOnClickListener {
            val intent1 = Intent(this,Singleplayer::class.java)
            startActivity(intent1)
        }

        multiplayer.setOnClickListener {
            val intent2 = Intent(this,Multiplayer::class.java)
            startActivity(intent2)
        }
    }
}
