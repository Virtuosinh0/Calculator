package com.example.calculator.models

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Operation (){
    var result by mutableIntStateOf(0)
    var viewFirstValue by mutableStateOf("")
    var viewSecondValue by mutableStateOf("")
    var viewMathProblem by mutableStateOf("")
    var firstValue = mutableListOf<Int>()
    var secondValue = mutableListOf<Int>()
    var numberFirstValue by mutableIntStateOf(0)
    var numberSecondValue by mutableIntStateOf(0)

    fun addNumber(number: Int) {
        if (viewMathProblem == "") {
            firstValue.add(number)
        }
        else{
            secondValue.add(number)
        }
        updateScreen()
    }
    fun eraseNumber(){
        if(secondValue.isNotEmpty()){
            secondValue.removeAt(secondValue.lastIndex)
        }else{
            if(viewMathProblem == ""){
                if(firstValue.isNotEmpty()){
                    firstValue.removeAt(firstValue.lastIndex)
                }
            }else{
                viewMathProblem = ""
            }
        }
        updateScreen()
    }

    fun updateScreen(){
        viewFirstValue = firstValue.joinToString("")
        viewSecondValue = secondValue.joinToString("")
    }

    fun mathOperation(op: String){
        if(secondValue.isEmpty()){
            viewMathProblem = op
        }else{
            endResult()
        }
        updateScreen()
    }

    fun calculate(list: List<Int>): Int {
        var tempNumber = 0
        for (i in list.indices) {
            tempNumber = tempNumber * 10 + list[i]
        }
        return tempNumber
    }

    fun endResult(){
        numberFirstValue = calculate(firstValue)
        numberSecondValue = calculate(secondValue)

        when (viewMathProblem) {
            "+" -> result = numberFirstValue + numberSecondValue
            "-" -> result = numberFirstValue - numberSecondValue
            "x" -> result = numberFirstValue * numberSecondValue
            "÷" -> result = numberFirstValue / numberSecondValue
        }
    }

    @Composable
    fun Visualizer() {
        numberFirstValue = calculate(firstValue)
        numberSecondValue = calculate(secondValue)
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = viewFirstValue + viewMathProblem + viewSecondValue, fontSize = 32.sp)
        }
    }
}