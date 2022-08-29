package com.murerwa.swapiapp.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.presentation.common.BottomBarScreen
import com.murerwa.swapiapp.presentation.navigation.BottomNavGraph
import com.murerwa.swapiapp.presentation.theme.MaroonPrimary
import com.murerwa.swapiapp.presentation.theme.YellowPrimary
import java.time.Year

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
//        topBar = {
//            TopAppBar(
//                backgroundColor = MaroonPrimary,
//                title = {
//                    Text(
//                        text = "",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Medium,
//                        color = Color.White
//                    )
//                },
//            )
//        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        BottomNavGraph(navController)
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