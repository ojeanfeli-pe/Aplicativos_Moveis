package com.example.aula17

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula17.ui.theme.Aula17Theme
import retrofit2.Retrofit
import retrofit2.await

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutMain()
        }
    }
}
@Composable
fun LayoutMain(){
    var listaUsuarios by remember { mutableStateOf<List<User>>(emptyList())}
    var erro by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {

        try{
            val respostaUsuarios = Instance.api.getUsers().await()

            listaUsuarios = respostaUsuarios

        }catch (e: Exception) {

            erro = "Erro ao carregar dados: ${e.message}"
        }
    }

        Column (modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)){

            Text(text = "LISTA DE USUÁRIOS", fontSize = 25.sp)

            Spacer(modifier = Modifier.height(15.dp))

            if(erro.isNotBlank()){

                Text(text = erro)
            }else{

                LazyColumn {
                    items(listaUsuarios){

                        usuario ->
                        Text(text = "${usuario.name} (${usuario.email})")

                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }

        }
    }
