package com.murerwa.swapiapp.presentation.screens.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.presentation.theme.YellowPrimary
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    filmViewModel: FilmViewModel = getViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(YellowPrimary)
    ){
        val response = filmViewModel.filmsResponse

        if (response.value != null) {
            Text(
                text = response.value!!.allFilms.toString(),
                modifier = Modifier.fillMaxSize(),
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}