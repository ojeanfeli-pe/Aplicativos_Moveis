package com.example.aula09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutActivit2()
        }
    }
}
@Composable
fun LayoutActivit2(){
    var c by remember { mutableStateOf("")}
    var f by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "-/-CONVERÇÃO DE TEMPERATURA-/-",
            fontSize = 22.sp)

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = c ,
            onValueChange = {
                c = it
                var cFloat = c.toFloatOrNull() ?: 0f
                //CONVERTER CELSIUS EM FAHRENHEIT
                f = (cFloat * 9/5) + 32
                },
            label = {Text(text = "Temperatura em Celsius:")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = "Temperatura em Fahrenheit: $f",
            fontSize = 22.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayout2(){
    LayoutActivit2()
}
