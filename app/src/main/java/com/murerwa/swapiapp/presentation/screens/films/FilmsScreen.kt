package com.murerwa.swapiapp.presentation.screens.films

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.presentation.common.ErrorScreen
import com.murerwa.swapiapp.presentation.theme.YellowPrimary
import org.koin.androidx.compose.getViewModel
import com.murerwa.swapiapp.R
import com.murerwa.swapiapp.presentation.screens.films.cards.FilmCard
import com.murerwa.swapiapp.presentation.theme.MaroonPrimary

@Composable
fun FilmsScreen(
    navController: NavHostController,
    viewModel: FilmViewModel = getViewModel()
) {
    val state =
        viewModel.filmsResponse.value

    Column(
        modifier = Modifier.fillMaxSize()
            .background(YellowPrimary)
    ) {
        TopAppBar(
            backgroundColor = MaroonPrimary,
            title = {
                Text(
                    text = "Star Wars Films",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            },
        )
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color(0xFFEAE6E7)),
            contentAlignment = Alignment.Center,
        ) {
            when (state) {
                is UIState.Loading -> {
                    CircularProgressIndicator()
                }
                is UIState.Success -> {
                    val films = state.value?.allFilms?.films

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(films?.size ?: 0) { item ->
                            val film = films!![item]

                            FilmCard(
                                film = film,
                            )
                        }
                    }
                }
                is UIState.Error -> {
                    if (state.isNetworkError) {
                        ErrorScreen(
                            message = "We encountered a network error. " +
                                    "Please check your internet connection and try again.",
                            imageDrawable = R.drawable.ic_error_internet
                        )
                    } else {
                        ErrorScreen(message = "Sorry. Something went wrong while loading the data.")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun FilmsScreenPreview() {
    FilmsScreen(rememberNavController())
}