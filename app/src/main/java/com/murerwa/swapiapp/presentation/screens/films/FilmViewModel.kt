package com.murerwa.swapiapp.presentation.screens.films

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murerwa.swapiapp.FilmDetailsQuery
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import com.murerwa.swapiapp.presentation.utils.convertToUIState
import kotlinx.coroutines.launch

class FilmViewModel(
    private val filmsRepository: FilmsRepository
): ViewModel() {

    private val _filmsResponse: MutableState<UIState<FilmsQuery.Data?>> = mutableStateOf(
        UIState.Loading)
    val filmsResponse = _filmsResponse

    private val _filmDetailsResponse: MutableState<UIState<FilmDetailsQuery.Data?>> = mutableStateOf(
        UIState.Loading)
    val filmDetailsResponse = _filmDetailsResponse

    fun getFilms() = viewModelScope.launch {
        val response = filmsRepository.getFilms()

        _filmsResponse.value = convertToUIState(response)
    }

    fun getFilmDetails(filmId: String) = viewModelScope.launch {
        val response = filmsRepository.getFilmDetails(filmId)

        _filmDetailsResponse.value = convertToUIState(response)
    }
}