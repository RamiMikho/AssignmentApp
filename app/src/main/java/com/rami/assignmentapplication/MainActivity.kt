package com.rami.assignmentapplication

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var currentScore : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val AddScore = findViewById<Button>(R.id.AddScore)
        val ReduceScore = findViewById<Button>(R.id.ReduceScore)
        val Reset = findViewById<Button>(R.id.Reset)
        val mediaPlayer = MediaPlayer.create(this, R.raw.wind_chimes)

        val Score = findViewById<TextView>(R.id.Score)

        savedInstanceState?.let {
            //retrieve the score
            currentScore = savedInstanceState.getInt("currentScore", 0)
            Score.text = currentScore.toString()
        }

        AddScore.setOnClickListener {
            increment()
            Score.text = currentScore.toString()
            if(currentScore >= 15){
                mediaPlayer.start()
            }
        }
        ReduceScore.setOnClickListener{
            decrement()
            Score.text = currentScore.toString()
        }
        Reset.setOnClickListener{
            currentScore = 0
            Score.text = currentScore.toString()
            //logs and testing
            Log.d("MainActivity", "debug log msg from me!")
        }


    }
    override fun onSaveInstanceState(outState: Bundle) {
        // Save to outState
        outState.putInt("currentScore", currentScore)
        super.onSaveInstanceState(outState)
    }
    private fun increment() {
        currentScore += 1
        //Toast.makeText(this, " $currentScore", Toast.LENGTH_SHORT).show()
    }
    private fun decrement() {
        if (currentScore > 0) {
            currentScore -= 1
            //Toast.makeText(this, " $currentScore", Toast.LENGTH_SHORT).show()
        }
    }


    //
    //mediaPlayer.start()
}