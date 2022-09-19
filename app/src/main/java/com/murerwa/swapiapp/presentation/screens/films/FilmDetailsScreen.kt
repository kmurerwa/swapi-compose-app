package com.murerwa.swapiapp.presentation.screens.films

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.murerwa.swapiapp.R
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.presentation.common.CustomTopAppBar
import com.murerwa.swapiapp.presentation.common.ErrorScreen
import com.murerwa.swapiapp.presentation.theme.BackgroundMain
import com.murerwa.swapiapp.presentation.theme.MaroonPrimary
import com.murerwa.swapiapp.presentation.theme.OrangePrimary
import com.murerwa.swapiapp.presentation.utils.getYear
import org.koin.androidx.compose.getViewModel

@Composable
fun FilmDetailsScreen(
    navController: NavHostController,
    filmId: String?,
    viewModel: FilmViewModel = getViewModel()
){
    if (!filmId.isNullOrEmpty()) {
        viewModel.getFilmDetails(filmId)
    }

    val state = viewModel.filmDetailsResponse.value

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
                val film = state.value?.film

                if (film == null) {
                    ErrorScreen(
                        message = "Could not fetch film details",
                    )
                } else {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "${film.title}",
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            color = OrangePrimary
                        )
                        Text(
                            text = "${film.releaseDate?.getYear()}",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaroonPrimary
                        )
                        Text(
                            text = "Directed by ${film.director}",
                            color = Color.Black,
                            fontStyle = FontStyle.Italic
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

@Preview
@Composable
fun FilmDetailsScreenPreview(){
    FilmDetailsScreen(rememberNavController(), null)
}
