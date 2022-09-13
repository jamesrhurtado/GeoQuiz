package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var pos = 0
    var lives = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        questions.add(Question("¿Es Arica capital de Lima?",false))
        questions.add(Question("¿Es Lima capital de Perú?",true))
        questions.add(Question("¿Es New York capital de EEUU?",false))
        questions.add(Question("¿Es Londres capital de Reino Unido?",true))
        questions.add(Question("¿Es Roma capital de Francia?",false))
        questions.add(Question("¿Es Auckland capital de Nueva Zelanda?",false))
        questions.add(Question("¿Es Santiago capital de Lima?",false))
        questions.add(Question("¿Es Montevideo capital de Chile?",false))
        questions.add(Question("¿Es Sao Paulo capital de Brasil?",false))
        questions.add(Question("¿Es La Paz capital de Bolivia?",false))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btAgain = findViewById<Button>(R.id.btAgain)
        val textQuestion = findViewById<TextView>(R.id.tvQuestion)
        val textLives = findViewById<TextView>(R.id.tvLives)
        textQuestion.text = questions[pos].sentence
        textLives.text = lives.toString()


        btYes.setOnClickListener{
            if(questions[pos].answer){
                Toast.makeText(this, "Right", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show()
                updateLives()
            }
            updateQuestion()
        }

        btNo.setOnClickListener {
            if(!questions[pos].answer){
                Toast.makeText(this, "Right", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show()
                updateLives()
            }
            updateQuestion()
        }

        btAgain.setOnClickListener{
            pos = 0
            textQuestion.text = questions[pos].sentence
            textLives.text = lives.toString()
        }
    }

    fun updateLives(){
        lives--
    }

    fun updateQuestion(){
        pos++
        val textQuestion = findViewById<TextView>(R.id.tvQuestion)
        val textLives = findViewById<TextView>(R.id.tvLives)
        textQuestion.text = questions[pos].sentence
        textLives.text = lives.toString()
    }
}