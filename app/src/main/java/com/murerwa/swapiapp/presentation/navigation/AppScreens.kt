package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

object AppScreens {

    sealed class NavScreens(
        val route: String
    ) {
        object FilmDetail: NavScreens(
            route = "detail_screen/{${ArgumentKeys.ID_ARGUMENT_KEY}}"
        ) {
            fun passId(id: String?): String {
                return this.route.replace("{${ArgumentKeys.ID_ARGUMENT_KEY}}", id ?: "")
            }
        }
    }

    sealed class BottomBarScreen(
        val route: String,
        val title: String,
        val icon: ImageVector
    ) {
        object Characters: BottomBarScreen(
            route = "characters",
            title = "Characters",
            icon = Icons.Default.Person
        )
        object Films: BottomBarScreen(
            route = "films",
            title = "Films",
            icon = Icons.Default.ThumbUp
        )
        object Planets: BottomBarScreen(
            route = "planets",
            title = "Planets",
            icon = Icons.Default.Star
        )
        object Starships: BottomBarScreen(
            route = "starships",
            title = "Starships",
            icon = Icons.Default.Place
        )
    }

    fun getRouteLabel(route: String): String {
        return when(route) {
            BottomBarScreen.Films.route -> "Films"
            BottomBarScreen.Characters.route -> "Characters"
            BottomBarScreen.Planets.route -> "Planets"
            BottomBarScreen.Starships.route -> "Starships"
            NavScreens.FilmDetail.route -> "Film Details"
            else -> "Star Wars"
        }
    }
}