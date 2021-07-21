package com.selfdefine.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onRadioButtonClicked(view: View) {}

    fun addition(operand1: Long, operand2: Long): String {
        return (operand1 + operand2).toString()
    }
    fun subtraction(operand1: Long, operand2: Long): String {
        return (operand1 - operand2).toString()
    }
    fun multiplication(operand1: Long, operand2: Long): String {
        return (operand1 * operand2).toString()
    }
    fun division(operand1: Long, operand2: Long): String {
        if(operand2 == 0L) return "∞"
        return (operand1 / operand2).toString()
    }

}