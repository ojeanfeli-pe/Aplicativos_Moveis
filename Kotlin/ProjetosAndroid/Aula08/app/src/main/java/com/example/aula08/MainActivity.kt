package com.example.aula08


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
import androidx.compose.material3.Button
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SomarValores()
        }
    }
}

@Composable
fun Mensagem() {

    var nome = "Jean"
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text( "Bom dia, $nome!  Princeso Lindo!")
        Text("Aula 08 - Android")
    }

}

@Composable
fun ExemploBotao(){

    var texto by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Clique no botão abaixo:")

        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            texto = if(texto.isEmpty()) "Parabéns! Você clicou no botão!" else ""  }) {
            Text("Clique aqui!")
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(text = texto)

    }
}

@Composable
fun ExemploTextField(){

    var nome by remember { mutableStateOf("")}
    var texto by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        TextField(value = nome,
            onValueChange = {nome = it},
            label = {Text (text = "Digite seu nome:")}
            )
        Button(onClick = {
            if (!nome.isEmpty()){
            texto = "bom dia $nome"
            }
            }){
            Text(text = "Mostrar nome")
        }
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = texto)

    }
}

@Composable
fun SomarValores(){

    var n1 by remember { mutableStateOf("") }
    var n2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0) }


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        TextField(value = n1,
            onValueChange = {n1 = it},
            label = {Text(text = "Informe um valor inteiro",)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

        Spacer(modifier = Modifier.height(25.dp))

        TextField(value = n2,
            onValueChange = {n2 = it},
            label = {Text(text = "Informe outro valor")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Button(onClick = {
            var  valor1 = n1.toIntOrNull() ?: 0
            var  valor2 = n2.toIntOrNull() ?: 0
            result = valor1 + valor2
        }) {
            Text(text = "Somar")
        }
        Text(text = "Resultado: $result")
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLayout() {
    //Mensagem()
    ExemploTextField()
}
