package com.example.videojuegos

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavManager(){
    val navController = rememberNavController()
    val user = Usuario("",0,0f)

    NavHost(navController, startDestination = "Home"){
        composable("Home"){
            HomeView( navController, user)
        }
        composable("Products"){
            MainView( navController)
        }

    }
}