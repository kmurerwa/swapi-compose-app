package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.presentation.common.BottomBarScreen
import com.murerwa.swapiapp.presentation.navigation.ArgumentKeys.FILM_ARGUMENT_KEY
import com.murerwa.swapiapp.presentation.navigation.ArgumentKeys.ID_ARGUMENT_KEY
import com.murerwa.swapiapp.presentation.screens.characters.CharactersScreen
import com.murerwa.swapiapp.presentation.screens.films.FilmDetailsScreen
import com.murerwa.swapiapp.presentation.screens.films.FilmsScreen
import com.murerwa.swapiapp.presentation.screens.main.MainScreen
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
        composable(
            route = NavScreens.FilmDetail.route,
            arguments = listOf(
                navArgument(ID_ARGUMENT_KEY) {
                    type = NavType.StringType
                }
            )
        ) {
            val filmId  = it.arguments?.getString(ID_ARGUMENT_KEY)

            FilmDetailsScreen(navController, filmId)
        }
    }

}