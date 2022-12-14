package com.murerwa.swapiapp.presentation.di

import com.murerwa.swapiapp.presentation.screens.characters.CharacterViewModel
import com.murerwa.swapiapp.presentation.screens.films.FilmViewModel
import com.murerwa.swapiapp.presentation.screens.planets.PlanetViewModel
import com.murerwa.swapiapp.presentation.screens.starships.StarshipViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel { FilmViewModel(get()) }
    viewModel { CharacterViewModel(get()) }
    viewModel { StarshipViewModel(get()) }
    viewModel { PlanetViewModel(get()) }
}