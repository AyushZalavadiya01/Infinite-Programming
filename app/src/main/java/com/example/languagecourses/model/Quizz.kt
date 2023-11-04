package com.example.languagecourses.model

data class Quizz(
    var id: String="",
    var title: String="",
    var title2: String="",
    var questions: MutableMap<String,Question> = mutableMapOf()
)
