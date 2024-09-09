package com.example.aula10.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula10.model.FolhaPagamento


class FolhaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutFolha()
        }
    }
}
@Composable
fun LayoutFolha(){
    var nome by remember { mutableStateOf("") }
    var horasTrab by remember { mutableStateOf("") }
    var valorHora by remember { mutableStateOf("") }
    var folhaCalculada by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center){

        TextField(value = nome,
        onValueChange = {nome = it},
        label = { Text(text = "Informe o nome do Funcionário: ")})

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = horasTrab,
            onValueChange = {horasTrab = it},
            label = { Text(text = "Informe as horas trabalhadas: ")})

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = valorHora,
            onValueChange = {valorHora = it},
            label = { Text(text = "Valor da hora: ")})

        Button(onClick = {

        //CONVERTER HORAS TRABALHAS E VALOR DA HORA PARA FLOAT:
        val horasTrabFloat = horasTrab.toFloatOrNull() ?:0f
        val valorHoraFloat= valorHora.toFloatOrNull() ?:0f

       //CRIA OBJETO DO TIPO FOLHAPAGAMENTO:
        var folha = FolhaPagamento(nome, horasTrabFloat, valorHoraFloat)

            folhaCalculada = folha.toString()
        }) {
        Text(text = "Calcular Folha de Pagamento")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = folhaCalculada, fontSize = 25.sp)
    }
}