package com.example.quiz.utils

import com.example.quiz.R
import com.example.quiz.model.Question

object Constants {
    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answers"

    fun getQuestions() : MutableList<Question>{
        val question = mutableListOf<Question>()

        val quest1 = Question(1,"identify the flag", R.drawable.arg, "Argentina","Somalia","Domican Republic","USA",1)

        question.add(quest1)

        val quest2 = Question(2,"identify the flag", R.drawable.iraq, "Mexico","Carrabian Island","Iraq","United Kingdom",3)

        question.add(quest2)

        val quest3 = Question(3,"identify the flag", R.drawable.sa, "Somalia","South Africa","Domican Republic","Sweden",2)

        question.add(quest3)

        val quest4 = Question(4,"identify the flag", R.drawable.israel, "Argentina","Israel","Vatican City ","Japan",2)

        question.add(quest4)

        val quest5 = Question(5,"identify the flag", R.drawable.mexico, "Pakistan","France","Ireland","Mexico",4)

        question.add(quest5)

        val quest6 = Question(6,"identify the flag", R.drawable.vietnam, "Vietnam","South Korea","China","Bhutan",1)

        question.add(quest6)

        val quest7 = Question(7,"identify the flag", R.drawable.japan, "Nepal","japan","Greenland","Iceland",2)

        question.add(quest7)

        val quest8 = Question(8,"identify the flag", R.drawable.ireland, "India","Afganisthan","Ireland","Iraq",3)

        question.add(quest8)

        val quest9 = Question(9,"identify the flag", R.drawable.iran, "Argentina","Somalia","iran","USA",3)

        question.add(quest9)

        val quest10 = Question(10,"identify the flag", R.drawable.ukraine, "Finland","Ukraine","UAE","Russia",2)

        question.add(quest10)

        return question
    }
}