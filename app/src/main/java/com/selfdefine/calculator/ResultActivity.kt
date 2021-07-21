package com.selfdefine.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val operand1 = intent.getStringExtra("OPERAND_1")
        val operand2 = intent.getStringExtra("OPERAND_2")
        val operator = intent.getStringExtra("OPERATOR")
        val result = intent.getStringExtra("RESULT")

        val questionView: TextView = findViewById(R.id.question)
        val resultView: TextView = findViewById(R.id.result)

        questionView.text = getString(R.string.question_view, operand1, operator, operand2)
        resultView.text = result
    }
}