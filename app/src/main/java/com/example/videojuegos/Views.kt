package com.example.videojuegos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun MainView(navegar: NavHostController,user: Usuario){
    val productos = VGmodelsView()
    var compras by remember { mutableStateOf(0f) }

    Column(Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Bienvenido a la tiendita Pandesin",Modifier.padding(top = 10.dp), textAlign = TextAlign.Center, fontSize = 35.sp)
        Button(onClick = {navegar.navigate("Home")},
            colors = ButtonDefaults.buttonColors(Color(0xFF7D6991)),
            modifier=Modifier.width(150.dp)) {
            Text("Regresar", fontSize = 18.sp) }
        LazyColumn() {
            items(productos.getProducts()){ prod->
                val edadbuy= when(prod.clasif){
                    "E"->true
                    "T"-> user.age> 13
                    "M"-> user.age>18
                    else -> false
                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row {
                            Image(painter = painterResource(prod.imagen),
                                contentDescription = "imagen de producto",
                                modifier = Modifier
                                    .size(60.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Column(modifier = Modifier.padding(5.dp)) {
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(prod.nombre, fontSize = 20.sp)
                                Text(text="$ ${prod.precio}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                Text(prod.consola, fontSize = 20.sp)
                                Spacer(modifier = Modifier.size(8.dp))
                                Button(onClick = {
                                    if (edadbuy){
                                        compras=prod.precio + compras
                                    }

                                }, colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Yellow,
                                    contentColor = Color.Black)) {Text("Agregar al carrito") }
                                Spacer(modifier = Modifier.size(10.dp))

                            }
                        }
                    }
                }

            }

        }
    }
}


