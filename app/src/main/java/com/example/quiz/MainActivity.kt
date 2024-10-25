package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quiz.ui.QuestionsActivity
import com.example.quiz.utils.Constants
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton : Button = findViewById(R.id.button_q)
        val editText : EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if (!editText.text.isEmpty()){
                Intent(this@MainActivity,QuestionsActivity :: class.java).also{
                    it.putExtra(Constants.USER_NAME,editText.text.toString())
                    startActivity(it)
                    finish()
                }

            }else{
                val view = findViewById<View>(R.id.main)
                Snackbar.make(view, "Enter name",Snackbar.LENGTH_LONG).show()
            }
        }

    }
}