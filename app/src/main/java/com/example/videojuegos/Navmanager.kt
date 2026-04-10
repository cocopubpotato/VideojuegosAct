package com.example.videojuegos

import androidx.compose.runtime.Composable
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
        composable("MainView"){
            MainView( navController,user=user)
        }

    }
}