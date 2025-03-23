package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.calculator.models.MathProblem
import com.example.calculator.models.Number
import com.example.calculator.models.Operation
import androidx.compose.ui.graphics.Color
import com.example.calculator.models.EraseButton
import com.example.calculator.models.ResultButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val eraseButton = EraseButton()
        val numberOne = Number(number = 1)
        val numberTwo = Number(number = 2)
        val numberThree = Number(number = 3)
        val numberFour = Number(number = 4)
        val numberFive = Number(number = 5)
        val numberSix = Number(number = 6)
        val numberSeven = Number(number = 7)
        val numberEight = Number(number = 8)
        val numberNine = Number(number = 9)
        val numberZero = Number(number = 0)
        val multiply = MathProblem(symbol = "x")
        val division = MathProblem(symbol = "÷")
        val minus = MathProblem(symbol = "-")
        val plus = MathProblem(symbol = "+")
        val around = MathProblem(symbol = "#")
        val dot = MathProblem(symbol = ",")
        val equal = ResultButton()
        val operation = Operation()

        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                Row {
                    Text(text = "")
                }
                Row {
                    operation.Visualizer()
                }
                Row {
                    eraseButton.SymbolButton(operation)
                    eraseButton.SymbolButton(operation)
                    eraseButton.SymbolButton(operation)
                    eraseButton.SymbolButton(operation)
                }
                Row {
                    numberSeven.NumberButton(operation)
                    numberEight.NumberButton(operation)
                    numberNine.NumberButton(operation)
                    multiply.SymbolButton(operation)
                }
                Row {
                    numberFour.NumberButton(operation)
                    numberFive.NumberButton(operation)
                    numberSix.NumberButton(operation)
                    minus.SymbolButton(operation)
                }
                Row {
                    numberOne.NumberButton(operation)
                    numberTwo.NumberButton(operation)
                    numberThree.NumberButton(operation)
                    plus.SymbolButton(operation)
                }
                Row {
                    around.SymbolButton(operation)
                    numberZero.NumberButton(operation)
                    dot.SymbolButton(operation)
                    equal.SymbolButton(operation)
                }
            }
        }
    }
}
