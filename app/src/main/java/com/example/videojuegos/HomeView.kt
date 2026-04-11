package com.example.videojuegos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch


@Composable
fun HomeView(navegar: NavHostController){
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableIntStateOf(0) }
    var cambio by remember { mutableFloatStateOf(0f) }

    val context= LocalContext.current
    val preferences= Usuarios(contexto= context)
    val corrutina= rememberCoroutineScope()

    Column(Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Bienvenido a la tiendita\nPandesin\n", textAlign = TextAlign.Center, fontSize = 35.sp)
        Text("Ingresa los siguientes datos",fontSize = 28.sp, textAlign = TextAlign.Center)
        Text("Tu nombre")
        TextField(value = nombre, onValueChange = {nombre=it})
        Text("Tu edad")
        TextField(value =edad.toString(), onValueChange = {
            if(it.isNotBlank()&&it.toIntOrNull() !=null){
                edad= it.toInt()}
        })
        Text("Tus ahorros")
        TextField(value = cambio.toString(), onValueChange = {
            if(it.isNotBlank()&&it.toFloatOrNull() !=null){
                cambio= it.toFloat()}
        })

        Spacer(Modifier.height(34.dp))

        Button(onClick = {
           corrutina.launch {
               preferences.guardarDatosPersonales(edad, nombre, cambio) }
            navegar.navigate("MainView") },
            colors = ButtonDefaults.buttonColors(Color(0xFF7D6991)),
            modifier=Modifier.width(150.dp)) {
            Text("Siguiente", fontSize = 18.sp) }
    }
}