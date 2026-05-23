package com.example.todo_list.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(){
    val navHostController = rememberNavController()
    NavHost(navHostController, startDestination = Screens.LoginScreen.route) {
        composable(Screens.LoginScreen.route){

        }
        composable(Screens.HomeScreen.route){

        }
        composable(Screens.ProfileScreen.route){

        }
    }
}