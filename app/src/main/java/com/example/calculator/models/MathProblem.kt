package com.example.calculator.models

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MathProblem (val symbol : String) {

    @Composable
    fun SymbolButton(source: Operation){
        Button(onClick = {
            source.mathOperation(symbol)
        },
            Modifier.padding(1.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text(text = "$symbol")
        }
    }
}