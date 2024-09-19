package com.example.aula13

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
fun Tela1(navController: NavController){

    var nome by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    val context = LocalContext.current

    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text = "Tela 01", fontSize = 25.sp )

        TextField(value = nome,
            onValueChange = {nome = it},
            label = { Text(text = "Informe o nome:")})

        Spacer(modifier = Modifier.height(15.dp))

        TextField(value = email,
            onValueChange = {email = it},
            label = { Text(text = "E-mail:")})

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {

            if(nome.isNotBlank() && email.isNotBlank()){
                navController.navigate("tela2/$nome/$email")
            }else{
                Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }

        }) {
            Text(text = "Ir para tela 2")

        }
    }

}

@Composable
fun Tela2(navController: NavController, nome: String?, email: String?){
    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text = "Bem Vindo, $nome!", fontSize = 25.sp )

        Text(text = "($email)", fontSize = 25.sp)

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Voltar para a tela 1")

        }
    }
}

@Composable
fun LayoutMain(){
    var navController = rememberNavController()

    Column (Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        NavHost(navController = navController ,
            startDestination = "tela1") {

            //rotas: quais layouts podemos navegar
            composable("tela1") { Tela1(navController = navController)}
            composable("tela2/{nome}/{email}") {
                backStackEntry -> Tela2(navController = navController,
                nome = backStackEntry.arguments?.getString("nome"),
                email = backStackEntry.arguments?.getString("email") )
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun Preview() {
    LayoutMain()
}
