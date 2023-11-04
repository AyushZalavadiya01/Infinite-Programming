package com.example.languagecourses.Activties

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.animation.AnimationUtils
import com.example.languagecourses.R
import com.example.languagecourses.databinding.ActivityResultBinding
import com.example.languagecourses.model.Quizz
import com.google.gson.Gson


@Suppress("DEPRECATION")
class ResultActivity : AppCompatActivity() {

    lateinit var quiz:Quizz
    lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()


        val bottom_down = AnimationUtils.loadAnimation(this, R.anim.bottom_down)

        binding.linearLayout2.animation =bottom_down


        binding.btnfinish.setOnClickListener {
            finishQuiz()
        }

    }

    private fun finishQuiz() {
        // Navigate back to the QuizActivity
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
        finish() // This will finish the ResultActivity
    }




    private fun setUpViews() {
        val quizData = intent.getStringExtra("QUIZ")
        quiz = Gson().fromJson<Quizz>(quizData, Quizz::class.java)
        calculateScore()
        setAnswerView()
    }

    private fun setAnswerView() {
        val builder = StringBuilder("")
        for (entry in quiz.questions.entries) {
            val question = entry.value
            builder.append("<font color'#18206F'><b>Question: ${question.description}</b></font><br/><br/>")
            builder.append("<font color='#009688'>Answer: ${question.answer}</font><br/><br/>")
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.txtAnswer.text = Html.fromHtml(builder.toString(), Html.FROM_HTML_MODE_COMPACT)
        } else {
            binding.txtAnswer.text = Html.fromHtml(builder.toString())
        }

    }

    private fun calculateScore() {
        var score = 0
        for (entry in quiz.questions.entries) {
            val question = entry.value
            if (question.answer == question.userAnswer) {
                score += 20
            }
        }
        binding.txtScore.text = "Your Score : $score"

    }

}