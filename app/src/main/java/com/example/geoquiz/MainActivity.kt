package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var pos = 0;

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
        questions.add(Question("¿Es Santiago capital de Lima?",false))
        questions.add(Question("¿Es Santiago capital de Chile?",true))
        questions.add(Question("¿Es La Paz capital de Brasil?",false))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val textQuestion = findViewById<TextView>(R.id.tvQuestion)
        textQuestion.text = questions[pos].sentence


        btYes.setOnClickListener{
            if(questions[pos].answer){
                Toast.makeText(this, "Right", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener {
            if(questions[pos].answer){
                Toast.makeText(this, "Right", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}