package com.example.todo_list.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo_list.ui.auth.LoginScreen

@Composable
fun NavGraph(){
    val navHostController = rememberNavController()
    NavHost(navHostController, startDestination = Screens.LoginScreen.route) {
        composable(Screens.LoginScreen.route){
            LoginScreen(onLoginSuccess = {
                navHostController.navigate(Screens.HomeScreen.route) {
                    popUpTo(Screens.LoginScreen.route) { inclusive = true }
                }
            })
        }
        composable(Screens.HomeScreen.route){

        }
        composable(Screens.ProfileScreen.route){

        }
    }
}