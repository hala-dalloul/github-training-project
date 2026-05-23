package com.example.todo_list.ui.navigation

sealed class Screens(val route: String) {
    object LoginScreen: Screens("login")
    object HomeScreen: Screens("home")
    object ProfileScreen: Screens("profile")
    object AddTaskScreen: Screens("add_task")
}