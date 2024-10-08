package com.example.aula11

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula11.ui.theme.Aula11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormLogin()
        }
    }
}
@Composable 
fun FormLogin(){
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var context =  LocalContext.current

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp), 
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        
        TextField(modifier = Modifier.fillMaxWidth(),
            value = usuario,
            onValueChange ={usuario = it},
            label = { Text(text = "Usuário")} )

        Spacer(modifier = Modifier.fillMaxWidth())

        TextField(modifier = Modifier.fillMaxWidth(),
            value = senha,
            onValueChange = {senha = it},
            label = { Text(text = "Senha")},
            visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.fillMaxWidth())

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
            when {
                usuario.isBlank() || senha.isBlank() -> {
                    Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                }

                !Validacao.validarLogin(usuario, senha) -> {
                    Toast.makeText(
                        context,
                        "Usuário ou senha inválido", Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    var intent = Intent(
                        context,
                        ContatoActivity::class.java
                    )

                    context.startActivity(intent)
                }
            }
        }) {
            Text(text = "Entrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    FormLogin()
}
