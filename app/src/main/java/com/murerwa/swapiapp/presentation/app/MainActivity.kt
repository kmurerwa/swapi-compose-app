package com.murerwa.swapiapp.presentation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.presentation.navigation.SetUpNavGraph
import com.murerwa.swapiapp.presentation.theme.SWAPIAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SWAPIAppTheme {
                val navController = rememberNavController()

                SetUpNavGraph(navController = navController)
            }
        }
    }
}