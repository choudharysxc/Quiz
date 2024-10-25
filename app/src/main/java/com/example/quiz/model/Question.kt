package com.example.quiz.model

data class Question(
    val id: Int,
    val Question:String,
    val Image: Int,
    val OptionOne : String,
    val OptionTwo : String,
    val OptionThree : String,
    val OptionFour : String,
    val CorrectOpt : Int
)
