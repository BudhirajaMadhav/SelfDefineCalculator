package com.selfdefine.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val operand1 = intent.getLongExtra("OPERAND_1", 0)
        val operand2 = intent.getLongExtra("OPERAND_2", 0)
        val operator = intent.getStringExtra("OPERATOR")
        val result = intent.getLongExtra("RESULT", 0)

        val questionView: TextView = findViewById(R.id.question)
        val resultView: TextView = findViewById(R.id.result)

        questionView.text = "$operand1 $operator $operand2 ="
        resultView.text = "$result"
    }
}