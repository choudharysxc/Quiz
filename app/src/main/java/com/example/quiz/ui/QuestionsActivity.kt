package com.example.quiz.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quiz.R
import com.example.quiz.model.Question
import com.example.quiz.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var prog_bar : ProgressBar
    private lateinit var textviewprogress : TextView
    private lateinit var textviewquestion : TextView
    private lateinit var imageview : ImageView

    private lateinit var optionone : TextView
    private lateinit var optiontwo : TextView
    private lateinit var optionthree : TextView
    private lateinit var optionfour : TextView

    private var questionCounter = 0
    private lateinit var questionList : MutableList<Question>

    private var selectedOptionPosition = 0
    private lateinit var button: Button
    private lateinit var currentQuestion : Question
    private  var answer = false
    private lateinit var name : String
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        questionList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionList.size}")

        prog_bar = findViewById(R.id.progress_bar1)
        textviewprogress = findViewById(R.id.text_view_progress)
        textviewquestion = findViewById(R.id.text1)
        imageview = findViewById(R.id.image_flag)
        button =findViewById(R.id.button_check)

        optionone = findViewById(R.id.option_1)
        optiontwo = findViewById(R.id.option_2)
        optionthree = findViewById(R.id.option_3)
        optionfour = findViewById(R.id.option_4)

        optionone.setOnClickListener(this)
        optiontwo.setOnClickListener(this)
        optionthree.setOnClickListener(this)
        optionfour.setOnClickListener(this)
        button.setOnClickListener(this)
        prog_bar.max = questionList.size
        showNextQuestion()

        if(intent.hasExtra(Constants.USER_NAME)){
            name = intent.getStringExtra(Constants.USER_NAME)!!
        }
    }


    private fun showNextQuestion(){

        if (questionCounter  <= questionList.size -1){

            resetOptions()
            val question = questionList[questionCounter]
            imageview.setImageResource(question.Image)
            prog_bar.progress = questionCounter
            textviewprogress.text = "${questionCounter}/${prog_bar.max}"
            textviewquestion.text = question.Question
            optionone.text = question.OptionOne
            optiontwo.text = question.OptionTwo
            optionthree.text = question.OptionThree
            optionfour.text = question.OptionFour

            button.text = "CHECk"
            currentQuestion = questionList[questionCounter]
        }else{
            button.text = "FINISH"
            Intent(this,ResultActivity::class.java).also{
                it.putExtra(Constants.USER_NAME,name)
                it.putExtra(Constants.SCORE,score)
                it.putExtra(Constants.TOTAL_QUESTIONS,questionList.size)
                startActivity(it)
            }
        }

        questionCounter++
        answer = false


    }

    private fun resetOptions(){
        val options = mutableListOf<TextView>()
        options.add(optionone)
        options.add(optiontwo)
        options.add(optionthree)
        options.add(optionfour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOption(textview:TextView, selectOptionNumber : Int){
        resetOptions()
        selectedOptionPosition = selectOptionNumber
        textview.setTextColor(Color.parseColor("#363A43"))
        textview.setTypeface(textview.typeface,Typeface.BOLD)
        textview.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.option_1 ->{
                selectedOption(optionone,1)
            }
            R.id.option_2 ->{
                selectedOption(optiontwo,2)
            }
            R.id.option_3 -> {
                selectedOption(optionthree,3)
            }
            R.id.option_4 ->{
                selectedOption(optionfour,4)
            }
            R.id.button_check -> {
                if(!answer){
                    checkAnswer()
                    answer = true

                }else{
                    showNextQuestion()
                    answer = false

                }
            }
        }
    }


    private fun checkAnswer(){
        answer = true

        if(selectedOptionPosition == currentQuestion.CorrectOpt){
            score++
            highlightanswer(selectedOptionPosition)
        }else{
            when(selectedOptionPosition){
                1 ->{
                    optionone.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
                2 ->{
                    optiontwo.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
                3 ->{
                    optionthree.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
                4 ->{
                    optionfour.background = ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                }
            }
        }
        button.text = "NEXT"
        showSolution()
    }
    private fun showSolution(){
        selectedOptionPosition = currentQuestion.CorrectOpt
        highlightanswer(selectedOptionPosition)
    }

    private fun highlightanswer(answers1 : Int){

        when(answers1){
            1 ->{
                optionone.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
            2 ->{
                optiontwo.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
            3 ->{
                optionthree.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
            4 ->{
                optionfour.background = ContextCompat.getDrawable(this,R.drawable.correct_option_border_bg)
            }
        }
    }
}