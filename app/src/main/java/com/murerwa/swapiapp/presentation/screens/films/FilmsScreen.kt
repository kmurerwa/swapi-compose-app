package com.murerwa.swapiapp.presentation.screens.films

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.presentation.common.ErrorScreen
import org.koin.androidx.compose.getViewModel
import com.murerwa.swapiapp.R
import com.murerwa.swapiapp.presentation.screens.films.components.FilmCard
import com.murerwa.swapiapp.presentation.theme.BackgroundMain

@Composable
fun FilmsScreen(
    navController: NavHostController,
    viewModel: FilmViewModel = getViewModel()
) {
    viewModel.getFilms()

    val state = viewModel.filmsResponse.value

    Box(
        modifier = Modifier.fillMaxSize()
            .background(BackgroundMain),
        contentAlignment = Alignment.Center,
    ) {
        when (state) {
            is UIState.Loading -> {
                CircularProgressIndicator()
            }
            is UIState.Success -> {
                val films = state.value?.allFilms?.films?.sortedBy { it?.releaseDate }

                if (films.isNullOrEmpty()) {
                    ErrorScreen(
                        message = "No films found",
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        items(films.size) { item ->
                            val film = films[item]

                            FilmCard(
                                film = film,
                                onClick = {
                                    navController.navigate(
                                        route = NavScreens.FilmDetail.passId(film?.id)
                                    )
                                }
                            )
                        }
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

@Preview
@Composable
fun FilmsScreenPreview() {
    FilmsScreen(rememberNavController())
}