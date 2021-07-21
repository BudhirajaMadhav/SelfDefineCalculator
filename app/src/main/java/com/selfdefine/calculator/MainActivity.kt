package com.selfdefine.calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.selfdefine.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var index: Int = -1
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calculate.setOnClickListener { calculate() }
    }

    private fun calculate() {
        val number1 = binding.firstInput.text.toString()
        val number2 = binding.secondInput.text.toString()

        val operatorArr = arrayOf("+", "-", "*", "/")
        val id = binding.radioGroup.checkedRadioButtonId
//        var index = -1

        var firstNumberL = 0L
        var secondNumberL = 0L

        if (number1 != "") {
            firstNumberL = number1.toLong()
        }
        if (number2 != "") {
            secondNumberL = number2.toLong()
        }

        val result = when (id) {
            R.id.radio_add -> addition(firstNumberL, secondNumberL)
            R.id.radio_sub -> subtraction(firstNumberL, secondNumberL)
            R.id.radio_mul -> multiplication(firstNumberL, secondNumberL)
            R.id.radio_div -> division(firstNumberL, secondNumberL)
            else -> "z"
        }

        var operand1 = "x"
        var operand2 = "y"
        var operator = "invalid"
        if (index != -1) {
            operator = operatorArr[index]
        }
        if (number1 != "") {
            operand1 = number1
        }
        if (number2 != "") {
            operand2 = number2
        }

        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra("OPERAND_1", operand1)
        intent.putExtra("OPERAND_2", operand2)
        intent.putExtra("OPERATOR", operator)
        intent.putExtra("RESULT", result)

        startActivity(intent)
    }

    private fun addition(operand1: Long, operand2: Long): String {
        index = 0
        return (operand1 + operand2).toString()
    }

    private fun subtraction(operand1: Long, operand2: Long): String {
        index = 1
        return (operand1 - operand2).toString()
    }

    private fun multiplication(operand1: Long, operand2: Long): String {
        index = 2
        return (operand1 * operand2).toString()
    }

    private fun division(operand1: Long, operand2: Long): String {
        index = 3
        if (operand2 == 0L) return "∞"
        return (operand1 / operand2.toDouble()).toString()
    }

}