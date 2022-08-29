package com.murerwa.swapiapp.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Characters: BottomBarScreen(
        route = "characters",
        title = "Characters",
        icon = Icons.Default.Home
    )
    object Films: BottomBarScreen(
        route = "films",
        title = "Films",
        icon = Icons.Default.Person
    )
}