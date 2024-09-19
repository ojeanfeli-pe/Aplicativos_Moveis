package com.example.aula14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson

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

    val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "lista") {

            composable("lista") { ListaContatos(navController) }
            composable("detalhes/{contatoJson}") {

            backStackEntry ->

            val contatoJson = backStackEntry.arguments?.getString("contatoJson")
            val contato = Gson().fromJson(contatoJson, Contato::class.java)

           DetalhesContato(navController, contato)
            }

        }
    }

@Composable
fun ListaContatos(navController: NavController){

    var listaContatos = listOf<Contato>(
        Contato("Elô",
            "4199993-5564",
            "elo@gmail.com",
            "Rua 1") ,

        Contato("Eduardo",
            "4199888-1478",
            "eduardo@gmail.com",
            "Rua 2") ,

        Contato("Mikaely",
            "4199774-5649",
            "mikaa@gmail.com",
            "Rua 3") ,

        Contato("Evandro",
            "4199658-1254",
            "evandroo@gmail.com",
            "Rua 4") ,
    )
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)){

        Spacer(modifier = Modifier.height(25.dp))

        Text(text = "LISTA DE CONTATOS", fontSize = 22.sp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(15.dp) )

        LazyColumn {
            items(listaContatos) {
                contato ->

                Text(text = "${contato.nome} (${contato.fone})",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .clickable {
                            //serializar p objeto "contato" num json
                            val contatoJson = Gson().toJson(contato)

                            //navegar para a tela "detalhes" passando
                            //json como paramêtro
                            navController.navigate("detalhes/$contatoJson")

                        })
            }
        }
    }
}

@Composable
fun DetalhesContato(navController: NavController, contato: Contato){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) {

        Spacer(modifier = Modifier.height(35.dp))

        Text(text = "DETALHES DO CONTATOS", fontSize = 22.sp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Nome: ${contato.nome}\n"+
        "Fone: ${contato.fone}\n"+
        "E-mail: ${contato.email}\n"+
        "Endereço: ${contato.endereco}\n",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth())

        Button(onClick = {

            navController.popBackStack()
        }) {
            Text(text = "VOLTAR")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayout(){
    LayoutMain()
}