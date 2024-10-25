package com.example.quiz.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.example.quiz.MainActivity
import com.example.quiz.R
import com.example.quiz.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewScore : TextView
    private lateinit var textViewName : TextView
    private lateinit var finishButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        textViewScore = findViewById(R.id.textview_score)
        textViewName = findViewById((R.id.textview_name))
        finishButton = findViewById(R.id.finish_button)

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score = intent.getIntExtra(Constants.SCORE,0)
        val name = intent.getStringExtra(Constants.USER_NAME)

        textViewScore.text = "Your score is $score out of $totalQuestion"
        textViewName.text = name

        finishButton.setOnClickListener{
            Intent(this,MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}