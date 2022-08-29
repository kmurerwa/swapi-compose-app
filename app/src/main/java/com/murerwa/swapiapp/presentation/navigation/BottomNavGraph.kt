package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.murerwa.swapiapp.presentation.common.BottomBarScreen
import com.murerwa.swapiapp.presentation.screens.characters.CharactersScreen
import com.murerwa.swapiapp.presentation.screens.films.FilmsScreen
import com.murerwa.swapiapp.presentation.screens.planets.PlanetScreen
import com.murerwa.swapiapp.presentation.screens.starships.StarshipsScreen

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
        composable(route = BottomBarScreen.Planets.route) {
            PlanetScreen()
        }
        composable(route = BottomBarScreen.Starships.route) {
            StarshipsScreen()
        }
    }

}