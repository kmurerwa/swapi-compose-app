package com.murerwa.swapiapp.presentation.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.murerwa.swapiapp.presentation.screens.main.MainScreen
import com.murerwa.swapiapp.presentation.theme.SWAPIAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SWAPIAppTheme {
                MainScreen()
            }
        }
    }
}