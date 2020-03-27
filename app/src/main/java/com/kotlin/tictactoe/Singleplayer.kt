package com.kotlin.tictactoe

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_singleplayer.btn1
import kotlinx.android.synthetic.main.activity_singleplayer.btn2
import kotlinx.android.synthetic.main.activity_singleplayer.btn3
import kotlinx.android.synthetic.main.activity_singleplayer.btn4
import kotlinx.android.synthetic.main.activity_singleplayer.btn5
import kotlinx.android.synthetic.main.activity_singleplayer.btn6
import kotlinx.android.synthetic.main.activity_singleplayer.btn7
import kotlinx.android.synthetic.main.activity_singleplayer.btn8
import kotlinx.android.synthetic.main.activity_singleplayer.btn9
import kotlin.random.Random

class Singleplayer :AppCompatActivity(), View.OnClickListener{

    val Human =ArrayList<Int>()
    val computer =ArrayList<Int>()
    var playerturn =1
    var gameover =false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleplayer)

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

    override fun onClick(v: View?) {
        var cellchoosed =0
        val button = v as Button
        when(button.id) {
            R.id.btn1 ->  cellchoosed=1
            R.id.btn2 ->  cellchoosed=2
            R.id.btn3 ->  cellchoosed=3
            R.id.btn4 ->  cellchoosed=4
            R.id.btn5 ->  cellchoosed=5
            R.id.btn6 ->  cellchoosed=6
            R.id.btn7 ->  cellchoosed=7
            R.id.btn8 ->  cellchoosed=8
            R.id.btn9 ->  cellchoosed=9
        }
        startGame(cellchoosed,button)
    }

    private fun startGame(cellchoosed: Int, button: Button) {
        if(playerturn==1){
            button.text ="X"
            button.setBackgroundColor(Color.parseColor("#E74B9E"))
            Human.add(cellchoosed)
            playerturn=2
            if(!gameover)
                computersturn()
        }else{
            button.text ="O"
            button.setBackgroundColor(Color.parseColor("#DA6407"))
            computer.add(cellchoosed)
            playerturn=1
        }
        button.isEnabled=false
        checkwinner()
    }
    private fun computersturn(){
        val emptycells = ArrayList<Int>()
        for(cellId in 1..9){
            if(!(Human.contains(cellId)||computer.contains(cellId))){
                emptycells.add(cellId)
            }
            val random = java.util.Random()
            val emptyindex = random.nextInt(emptycells.size-0)+0
            val cellchoosed = emptycells[emptyindex]
            val computerbutton : Button
            when(cellchoosed){
                1 -> computerbutton=btn1
                2 -> computerbutton=btn2
                3 -> computerbutton=btn3
                4 -> computerbutton=btn4
                5 -> computerbutton=btn5
                6 -> computerbutton=btn6
                7 -> computerbutton=btn7
                8 -> computerbutton=btn8
                9 -> computerbutton=btn9
                else ->computerbutton=btn1
            }
            startGame(cellId,computerbutton)
        }
    }
    private fun checkwinner() {
            var winner =-1

            if(Human.contains(1)&&Human.contains(2)&&Human.contains(3)){
                winner=1

            }else if(Human.contains(1)&&Human.contains(4)&&Human.contains(7)){
                winner=1
            }else if(Human.contains(4)&&Human.contains(5)&&Human.contains(6)){
                winner=1
            }else if(Human.contains(7)&&Human.contains(8)&&Human.contains(9)){
                winner=1
            }else if(Human.contains(2)&&Human.contains(5)&&Human.contains(8)){
                winner=1
            }else if(Human.contains(3)&&Human.contains(6)&&Human.contains(9)){
                winner=1
            }else if(Human.contains(1)&&Human.contains(5)&&Human.contains(9)){
                winner=1
            }else if(Human.contains(3)&&Human.contains(5)&&Human.contains(7)){
                winner=1
            }
            if(computer.contains(1)&&computer.contains(2)&&computer.contains(3)){
                winner=2
            }else if(computer.contains(1)&&computer.contains(4)&&computer.contains(7)){
                winner=2
            }else if(computer.contains(4)&&computer.contains(5)&&computer.contains(6)){
                winner=2
            }else if(computer.contains(7)&&computer.contains(8)&&computer.contains(9)){
                winner=2
            }else if(computer.contains(2)&&computer.contains(5)&&computer.contains(8)){
                winner=2
            }else if(computer.contains(3)&&computer.contains(6)&&computer.contains(9)){
                winner=2
            }else if(computer.contains(1)&&computer.contains(5)&&computer.contains(9)){
                winner=2
            }else if(computer.contains(3)&&computer.contains(5)&&computer.contains(7)){
                winner=2
            }
            if(winner!=-1){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Congracts")
                builder.setCancelable(false)
                if(winner==1){
                    gameover =true
                    builder.setMessage("You Won the game")
                    // Toast.makeText(this@Multiplayer,"Player X Won the game",Toast.LENGTH_LONG).show()
                } else if(winner==2){
                    gameover=true
                    builder.setMessage("Computer Won the game")
                    // Toast.makeText(this@Multiplayer,"Player O Won the game",Toast.LENGTH_LONG).show()
                }else{
                    builder.setMessage("Its a Tie!!")
                }
                builder.setPositiveButton("Play Again"){ dialogInterface: DialogInterface, i: Int ->
                    this.recreate()
                }
                builder.setNegativeButton("Quit Game"){ dialogInterface: DialogInterface, i: Int ->
                    val backintent = Intent(this,MainActivity::class.java)
                    startActivity(backintent)
                    finish()
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }
    }
}