package com.example.calculator.models

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Operation (){
    var result by mutableStateOf(0)
    var viewFirstValue by mutableStateOf("")
    var viewSecondValue by mutableStateOf("")
    var viewMathProblem by mutableStateOf("")
    var firstValue = mutableListOf<Int>()
    var secondValue = mutableListOf<Int>()
    var numberFirstValue by mutableStateOf(0)
    var numberSecondValue by mutableStateOf(0)

    fun AddNumber(number: Int) {
        if (viewMathProblem == "") {
            firstValue.add(number)
        }
        else{
            secondValue.add(number)
        }
        UpdateScreen()
    }
    fun EraseNumber(){
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
        UpdateScreen()
    }

    fun UpdateScreen(){
        viewFirstValue = firstValue.joinToString("")
        viewSecondValue = secondValue.joinToString("")
    }

    fun MathOperation(op: String){
        if(secondValue.isEmpty()){
            viewMathProblem = op
        }else{
            EndResult()
        }
        UpdateScreen()
    }

    fun Calculate(list: List<Int>): Int {
        var tempNumber = 0
        for (i in list.indices) {
            tempNumber = tempNumber * 10 + list[i]
        }
        return tempNumber
    }

    fun EndResult(){
        numberFirstValue = Calculate(firstValue)
        numberSecondValue = Calculate(secondValue)

        when (viewMathProblem) {
            "+" -> result = numberFirstValue + numberSecondValue
            "-" -> result = numberFirstValue - numberSecondValue
            "x" -> result = numberFirstValue * numberSecondValue
            "÷" -> result = numberFirstValue / numberSecondValue
        }
    }

    @Composable
    fun Visualizer() {
        numberFirstValue = Calculate(firstValue)
        numberSecondValue = Calculate(secondValue)
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = viewFirstValue + viewMathProblem + viewSecondValue, fontSize = 32.sp)
        }
    }
}