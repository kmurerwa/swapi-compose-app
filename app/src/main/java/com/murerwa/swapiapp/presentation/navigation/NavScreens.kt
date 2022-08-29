package com.murerwa.swapiapp.presentation.navigation

import com.murerwa.swapiapp.presentation.navigation.ArgumentKeys.ID_ARGUMENT_KEY

sealed class NavScreens(val route: String) {
    object Home : NavScreens(route = "home_screen")
    object Detail: NavScreens(route = "detail_screen/{$ID_ARGUMENT_KEY}") {
        fun passId(id: String): String {
            return this.route.replace("{$ID_ARGUMENT_KEY}", id)
        }
    }
}