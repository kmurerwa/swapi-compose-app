package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.murerwa.swapiapp.presentation.common.BottomBarScreen
import com.murerwa.swapiapp.presentation.screens.characters.CharactersScreen
import com.murerwa.swapiapp.presentation.screens.films.FilmsScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Films.route
    ) {
        composable(route = BottomBarScreen.Films.route) {
            FilmsScreen(navController)
        }
        composable(route = BottomBarScreen.Characters.route) {
            CharactersScreen()
        }
    }

}