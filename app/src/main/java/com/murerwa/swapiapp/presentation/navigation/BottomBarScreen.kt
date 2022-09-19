package com.murerwa.swapiapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

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