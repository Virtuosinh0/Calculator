package com.example.calculator.models

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ResultButton {
    @Composable
    fun SymbolButton(source: Operation){
        Button(onClick = {
            source.endResult()
        },
            modifier = Modifier
                .padding(1.dp)
                .size(100.dp, 75.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Text(text = "=", fontSize = 25.sp)
        }
    }
}