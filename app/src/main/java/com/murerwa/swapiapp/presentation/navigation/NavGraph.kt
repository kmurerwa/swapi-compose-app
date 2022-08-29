package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.murerwa.swapiapp.presentation.screens.main.MainScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavScreens.Main.route
    ) {
        composable(
            route = NavScreens.Main.route
        ) {
            MainScreen()
        }
    }
}