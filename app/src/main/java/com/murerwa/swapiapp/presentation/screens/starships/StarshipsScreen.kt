package com.murerwa.swapiapp.presentation.screens.starships

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
import com.murerwa.swapiapp.presentation.screens.planets.components.PlanetCard
import com.murerwa.swapiapp.presentation.screens.starships.components.StarshipCard
import com.murerwa.swapiapp.presentation.theme.BackgroundMain
import org.koin.androidx.compose.getViewModel

@Composable
fun StarshipsScreen(
    viewModel: StarshipViewModel = getViewModel()
) {
    viewModel.getStarships()

    val state = viewModel.starshipsResponse.value

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
                val starships = state.value?.allStarships?.starships

                if (starships.isNullOrEmpty()) {
                    ErrorScreen(
                        message = "No starships found",
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(starships.size) { item ->
                            val starship = starships[item]

                            StarshipCard(
                                starship = starship
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
fun StarshipsScreenPreview() {
    StarshipsScreen()
}