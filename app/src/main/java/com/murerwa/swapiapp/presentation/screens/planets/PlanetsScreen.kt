package com.murerwa.swapiapp.presentation.screens.planets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.murerwa.swapiapp.R
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.presentation.common.ErrorScreen
import com.murerwa.swapiapp.presentation.screens.characters.components.CharacterCard
import com.murerwa.swapiapp.presentation.screens.planets.components.PlanetCard
import com.murerwa.swapiapp.presentation.theme.BackgroundMain
import org.koin.androidx.compose.getViewModel

@Composable
fun PlanetScreen(
    viewModel: PlanetViewModel = getViewModel()
) {

    viewModel.getPlanets()

    val state = viewModel.planetsResponse.value

    Box(
        modifier = Modifier.fillMaxSize()
            .background(BackgroundMain)
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        when (state) {
            is UIState.Loading -> {
                CircularProgressIndicator()
            }
            is UIState.Success -> {
                val planets = state.value?.allPlanets?.planets

                if (planets.isNullOrEmpty()) {
                    ErrorScreen(
                        message = "No planets found",
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(planets.size) { item ->
                            val planet = planets[item]

                            PlanetCard(
                                planet = planet
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

@Composable
@Preview(showBackground = true)
fun PlanetScreenPreview() {
    PlanetScreen()
}