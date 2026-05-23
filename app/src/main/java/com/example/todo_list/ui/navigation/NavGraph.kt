package com.example.todo_list.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo_list.ui.auth.LoginScreen
import com.example.todo_list.ui.home.HomeScreen
import com.example.todo_list.ui.profile.ProfileScreen
import com.example.todo_list.ui.addTask.AddTaskScreen
import com.example.todo_list.data.model.Task
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

@Composable
fun NavGraph(){
    val navHostController = rememberNavController()
    
    val tasks = remember {
        mutableStateListOf(
            Task("Design UI", "Create login and home screens"),
            Task("API Integration", "Connect app with backend"),
            Task("Fix Bugs", "Resolve crashes in auth flow")
        ) 
    }

    NavHost(navHostController, startDestination = Screens.LoginScreen.route) {
        composable(Screens.LoginScreen.route){
            LoginScreen(onLoginSuccess = {
                navHostController.navigate(Screens.HomeScreen.route) {
                    popUpTo(Screens.LoginScreen.route) { inclusive = true }
                }
            })
        }
        composable(Screens.HomeScreen.route){
            HomeScreen(
                tasks = tasks,
                onAddTaskClick = { navHostController.navigate(Screens.AddTaskScreen.route) },
                onProfileClick = { navHostController.navigate(Screens.ProfileScreen.route) }
            )
        }
        composable(Screens.ProfileScreen.route){
            ProfileScreen(
                userName = "admin",
                email = "admin@email.com", 
                onBackClick = { navHostController.popBackStack() }
            )
        }
        composable(Screens.AddTaskScreen.route){
            AddTaskScreen(
                onSaveClick = { title, desc -> 
                    tasks.add(Task(title, desc))
                    navHostController.popBackStack()
                },
                onBackClick = { navHostController.popBackStack() }
            )
        }
    }
}