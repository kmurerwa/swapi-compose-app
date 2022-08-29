package com.murerwa.swapiapp.presentation.screens.film

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import kotlinx.coroutines.launch

class FilmViewModel(
    private val filmsRepository: FilmsRepository
): ViewModel() {

    private val _filmsResponse: MutableState<FilmsQuery.Data?> = mutableStateOf(null)
    val filmsResponse= _filmsResponse

    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch {
            _filmsResponse.value = filmsRepository.getFilms()
        }
    }
}