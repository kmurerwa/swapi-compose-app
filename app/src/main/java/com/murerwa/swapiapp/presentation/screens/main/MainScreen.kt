package com.murerwa.swapiapp.presentation.screens.main

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.presentation.common.CustomTopAppBar
import com.murerwa.swapiapp.presentation.common.HomeTopAppBar
import com.murerwa.swapiapp.presentation.navigation.AppScreens.BottomBarScreen
import com.murerwa.swapiapp.presentation.navigation.AppScreens.getRouteLabel
import com.murerwa.swapiapp.presentation.navigation.BottomNavGraph
import com.murerwa.swapiapp.presentation.theme.MaroonPrimary
import com.murerwa.swapiapp.presentation.theme.YellowPrimary

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isHomeScreen = currentDestination?.hierarchy?.any { it.route in listOf(
        BottomBarScreen.Films.route,
        BottomBarScreen.Characters.route,
        BottomBarScreen.Planets.route,
        BottomBarScreen.Starships.route
    ) } ?: false

    val title = getRouteLabel(currentDestination?.route ?: BottomBarScreen.Films.route)

    val density = LocalDensity.current

    Scaffold(
        topBar = {
            if (isHomeScreen) {
                HomeTopAppBar(
                    title = title,
                )
            } else {
                CustomTopAppBar(
                    title = title,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        },
        bottomBar = {
            if (isHomeScreen) {
                BottomBar(navController = navController)
            }
        }
    ){ innerPadding ->
        // Apply the padding globally to the whole BottomNavScreensController
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Films,
        BottomBarScreen.Characters,
        BottomBarScreen.Planets,
        BottomBarScreen.Starships
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = { Text(screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = Color.White,
        selectedContentColor = YellowPrimary,
        modifier = Modifier.background(MaroonPrimary),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
    )
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen()
}