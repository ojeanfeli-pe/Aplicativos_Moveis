package com.example.exercicioaula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import com.example.exercicioaula.ui.theme.ExercicioAulaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                TarefasLista()
        }
    }
}
@Composable
fun TarefasLista(){
    var tarefa by remember { mutableStateOf("") }
    var tarefinhas by remember {mutableStateOf(listOf(tarefa))}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "INFORME A TAREFA")
        
        TextField(value = tarefa,
            onValueChange = {tarefa = it},
            label = { Text(text = "Digite uma nova Tarefa")})



        Button(onClick = {
            tarefinhas += tarefa
        }) {
            Text(text = "SALVAR TAREFA")
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(tarefinhas){

                tarefa -> Text(text = tarefa)

             Button(onClick = {
                     tarefinhas = tarefinhas.filter { it != tarefa }

             }) {
                 Text(text = "X")
             }

            }


            }
        }
    }


@Preview(showBackground = true)
@Composable
fun PreviewTarefas(){
    TarefasLista()
}