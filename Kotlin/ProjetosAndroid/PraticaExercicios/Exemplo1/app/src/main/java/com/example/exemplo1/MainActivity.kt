package com.example.exemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import retrofit2.await

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaPostsScreen()
        }
    }
}
@Composable
fun ListaPostsScreen() {
Column (modifier = Modifier.fillMaxWidth().padding(25.dp)){

    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }
    var erro by remember { mutableStateOf<String?>(null) }

    // Fazendo a requisição no LaunchedEffect para que ocorra uma vez
    LaunchedEffect(Unit) {
        try {
            val response = RetrofitInstance.api.getPosts().await()  // Faz a requisição
            posts = response.filter {it.userId == 2} // Armazena os posts no estado
        } catch (e: Exception) {
            erro = "Erro ao carregar dados"
        }
    }
    if (erro != null) {
        Text(text = erro!!)
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(posts) { post ->
                PostItem(post)
            }
        }
    }
}
}

@Composable
fun PostItem(post: Post) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(text = "UserId: ${post.userId}", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Id: ${post.id}", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Title: ${post.title}", modifier = Modifier.padding(bottom = 8.dp))
        Text(text = "Body: ${post.body}", modifier = Modifier.padding(bottom = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListaPostsScreen() {
    ListaPostsScreen()
}

