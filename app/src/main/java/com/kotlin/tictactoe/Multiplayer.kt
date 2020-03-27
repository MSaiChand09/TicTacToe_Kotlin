package com.kotlin.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_multiplayer.*

class Multiplayer : AppCompatActivity(), View.OnClickListener {

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1


    override fun onClick(v: View?) {
        val button = v as Button
        var selectedcell  =0
        when(button.id){
            R.id.btn1 ->  selectedcell=1
            R.id.btn2 ->  selectedcell=2
            R.id.btn3 ->  selectedcell=3
            R.id.btn4 ->  selectedcell=4
            R.id.btn5 ->  selectedcell=5
            R.id.btn6 ->  selectedcell=6
            R.id.btn7 ->  selectedcell=7
            R.id.btn8 ->  selectedcell=8
            R.id.btn9 ->  selectedcell=9
        }
        playGame(selectedcell,button)
    }

    private fun playGame(selectedbox :Int,buttonClicked :Button) {

        if(activePlayer==1){
            buttonClicked.text ="X"
            buttonClicked.setBackgroundColor(Color.parseColor("#E28C4A"))
            player1.add(selectedbox)
            activePlayer=2
        }else{
            buttonClicked.text="O"
            buttonClicked.setBackgroundColor(Color.parseColor("#89D15B"))
            player2.add(selectedbox)
            activePlayer=1

        }
        buttonClicked.isEnabled=false
        checkwinner()
      }
     private fun checkwinner() {
        var winner =-1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1
        }else if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1
        }else if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1
        }else if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1
        }else if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1
        }else if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1
        }else if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1
        }else if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2
        }else if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2
        }else if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2
        }else if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2
        }else if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2
        }else if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2
        }else if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2
        }else if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2
        }
        if(winner!=-1){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Congracts")
            builder.setCancelable(false)
            if(winner==1){
                builder.setMessage("Player X Rocked the game")
               // Toast.makeText(this@Multiplayer,"Player X Won the game",Toast.LENGTH_LONG).show()
            } else if(winner==2){
                builder.setMessage("Player O Rocked the game")
               // Toast.makeText(this@Multiplayer,"Player O Won the game",Toast.LENGTH_LONG).show()
            }else{
                builder.setMessage("Both Players are smart enough!!")
            }
            builder.setPositiveButton("Play Again"){ dialogInterface: DialogInterface, i: Int ->
              this.recreate()
            }
            builder.setNegativeButton("Quit Game"){ dialogInterface: DialogInterface, i: Int ->
                val backintent = Intent(this,MainActivity::class.java)
                startActivity(backintent)
                finish()
            }
            val dialog :AlertDialog = builder.create()
            dialog.show()
        }
      /*  if(player1.size >=3){
            var winningarr = Array<Int>(){}
            var winningset = ArrayList<Array<Int>>()
            if(player1.equals(winningset) )
        }*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplayer)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
    }
}
