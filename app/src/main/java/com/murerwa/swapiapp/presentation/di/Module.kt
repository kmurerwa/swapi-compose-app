package com.murerwa.swapiapp.presentation.di

import com.murerwa.swapiapp.presentation.screens.films.FilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModules = module {
    viewModel { FilmViewModel(get()) }
}