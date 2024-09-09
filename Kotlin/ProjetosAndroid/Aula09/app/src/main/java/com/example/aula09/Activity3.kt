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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula09.ui.theme.Aula09Theme

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutActivit3()
        }
    }
}

@Composable
fun LayoutActivit3(){
    var nome by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
      //CHAMA O CUSTOM TEXT FIELD
        CustomTextField(valor = nome,
            onvalueChange = {nome = it},
            label = "Digite seu nome: " )

        Spacer(modifier = Modifier.height(22.dp))

        CustomTextField(valor = endereco,
            onvalueChange = {endereco = it},
            label = "Digite seu Endereço: ")

        Spacer(modifier = Modifier.height(22.dp))

        CustomTextField(valor = email,
            onvalueChange = {email = it},
            label = "Digite seu Email: ")

        Text(text = "\nNome: $nome " +
                "\nEndereço: $endereco " +
                "\nE-mail: $email ",
            fontSize = 20.sp)
    }
}
@Composable
fun CustomTextField(
    valor : String,
    onvalueChange: (String) -> Unit,
    label : String){

    //valor : variável associada ao TextField
    // onValueChange: callback para quando texto mudar
    //label: texto para a label

    TextField(value = valor,
    onValueChange = onvalueChange,
    label = { Text(text = label)}
    )
}

@Preview
@Composable
fun PreviewLayout3(){
    LayoutActivit3()
}