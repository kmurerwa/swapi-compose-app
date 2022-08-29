package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.murerwa.swapiapp.presentation.screens.film.HomeScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavScreens.Home.route
    ) {
        composable(
            route = NavScreens.Home.route
        ) {
            HomeScreen(navController)
        }
//        composable(
//            route = Screen.Detail.route,
//            arguments = listOf(
//                navArgument(CHARACTER_ARGUMENT_KEY) {
//                    type = CharacterItemParamType()
//                }
//            )
//        ) {
//            val passedCharacter  = it.arguments
//                ?.getParcelable(CHARACTER_ARGUMENT_KEY) as CharacterItem?
//
//            DetailScreen(navController, passedCharacter)
//        }
    }
}