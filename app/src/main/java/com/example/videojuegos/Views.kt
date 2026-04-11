package com.example.videojuegos

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun MainView(navegar: NavHostController) {
    val productos = VGmodelsView()
    var compras by remember { mutableStateOf(0f) }
    var carrito by remember { mutableStateOf(listOf<VGmodels>()) }
    var mostrarCarrito by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val preferences = Usuarios(contexto = context)
    var name = preferences.name.collectAsState("")
    var age = preferences.age.collectAsState(0)
    var cash = preferences.cash.collectAsState(0f)


    Column(Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Bienvenido a la tiendita Pandesin",
            Modifier.padding(top = 10.dp),
            textAlign = TextAlign.Center,
            fontSize = 35.sp
        )
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { navegar.navigate("Home") },
                colors = ButtonDefaults.buttonColors(Color(0xFF7D6991)),
                modifier = Modifier.width(150.dp)
            ) {
                Text("Regresar", fontSize = 18.sp)
            }

            Button(onClick = { mostrarCarrito = true },
                colors = ButtonDefaults.buttonColors(Color(0xFF7D6991)),
                modifier = Modifier.width(150.dp)
            ) {
                Text("Finalizar compra", fontSize = 18.sp)
            }
        }


        LazyColumn() {
            items(productos.getProducts()) { prod ->
                val yaAgregado = carrito.any { it.nombre == prod.nombre }
                val edadbuy = when (prod.clasif) {
                    "E" -> true
                    "T" -> age.value >= 13
                    "M" -> age.value >= 18
                    else -> false
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row {
                            Image(
                                painter = painterResource(prod.imagen),
                                contentDescription = "imagen de producto",
                                modifier = Modifier
                                    .size(60.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Column(modifier = Modifier.padding(5.dp)) {
                                Spacer(modifier = Modifier.size(10.dp))
                                Text(prod.nombre, fontSize = 20.sp)
                                Text(
                                    text = "$ ${prod.precio}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(prod.consola, fontSize = 20.sp)
                                Spacer(modifier = Modifier.size(8.dp))
                                Button(
                                    onClick = {
                                        if (edadbuy) {
                                            val puedeComprar = (cash.value - compras) >= prod.precio
                                            if (puedeComprar && !yaAgregado) {
                                                carrito = carrito + prod
                                                compras += prod.precio
                                                Log.d("EVENTO", "provando el evento del producto..")
                                            }
                                        }
                                    }, colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Yellow,
                                        contentColor = Color.Black
                                    )
                                ) { Text(if (yaAgregado) "Agregado" else "Agregar al carrito") }

                                //Spacer(modifier = Modifier.size(10.dp))
                            }
                        }
                    }
                }
            }
        }

                                    //boton finaliar compra resultados
        if (mostrarCarrito) {
            androidx.compose.ui.window.Dialog(
                onDismissRequest = { mostrarCarrito = false }
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("${name.value} deseas confirmar tu compra?", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.size(10.dp))
                        LazyColumn {
                            items(carrito) { prod ->
                                Row(modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(prod.nombre)
                                    Text("$ ${prod.precio}")
                                }
                                Spacer(modifier = Modifier.size(10.dp))

                            }
                        }
                        Text("Total: $ $compras",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp)
                    }

                }
            }
        }
    }
}


