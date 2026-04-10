package com.example.videojuegos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Preview(showBackground = true)
@Composable
fun HomeView(){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var cash by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        Text("Bienvenido a la tiendita" )
        Text("Ingresa Los siguientes datos")
        Text("Tu nombre")
        TextField(value = name, onValueChange = {name=it})
        Text("Tu edad")
        TextField(value = age, onValueChange = {age=it})
        Text("Tu nombre")
        TextField(value = cash, onValueChange = {cash=it})

        Button(onClick = {}) {Text("Siguiente") }
    }
}