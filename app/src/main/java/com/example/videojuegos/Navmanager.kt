package com.example.videojuegos

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavManager(){
    val navController = rememberNavController()


    NavHost(navController, startDestination = "Home"){
        composable("Home"){
            HomeView( navController)
        }
        composable("MainView"){
            MainView( navController)
        }
    }
}