package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.Opreration.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lastNumber : Double = 0.0
    private var currentOperation :Opreration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonListener()

    }

    private fun buttonListener() {

        button_clear.setOnClickListener {
            clearInput()

        }

        button_plus.setOnClickListener {
            prepareOperation(Plus)
        }
        button_division.setOnClickListener {
            prepareOperation(Div)
        }
        button_multiply.setOnClickListener {
            prepareOperation(Mul)
        }
        button_minus.setOnClickListener {
            prepareOperation(Minus)
        }
        button_result.setOnClickListener {
            val result = doCurrentOperation()
            textNumber.text = result.toString()
        }

    }

    private fun doCurrentOperation() : Double {
        val secondNumber = textNumber.text.toString().toDouble()

       return when (currentOperation){
            Plus -> lastNumber + secondNumber
            Minus -> lastNumber - secondNumber
            Div -> lastNumber / secondNumber
            Mul -> lastNumber * secondNumber
            null -> 0.0
        }
    }

     fun onClickNumber(v:View){
        val newDigits = (v as Button).text.toString()
        val oldDigits = textNumber.text.toString()
        val newTextNumber = oldDigits + newDigits
        textNumber.text = newTextNumber
    }

    private fun clearInput(){
        textNumber.text = ""
    }

    private fun prepareOperation(operation: Opreration){
        lastNumber= textNumber.text.toString().toDouble()
        clearInput()
        currentOperation = operation
    }
}