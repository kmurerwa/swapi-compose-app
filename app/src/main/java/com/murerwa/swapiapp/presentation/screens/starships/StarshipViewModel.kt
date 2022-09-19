package com.murerwa.swapiapp.presentation.screens.starships

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murerwa.swapiapp.StarshipDetailsQuery
import com.murerwa.swapiapp.StarshipsQuery
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.domain.repository.StarshipsRepository
import com.murerwa.swapiapp.presentation.utils.convertToUIState
import kotlinx.coroutines.launch

class StarshipViewModel(
    private val starshipsRepository: StarshipsRepository
): ViewModel() {
    private val _starshipsResponse: MutableState<UIState<StarshipsQuery.Data?>> = mutableStateOf(UIState.Loading)
    val starshipsResponse = _starshipsResponse

    private val _starshipDetailsResponse: MutableState<UIState<StarshipDetailsQuery.Data?>> = mutableStateOf(UIState.Loading)
    val starshipDetailsResponse = _starshipDetailsResponse

    fun getStarships() = viewModelScope.launch {
        val response = starshipsRepository.getStarships()

        _starshipsResponse.value = convertToUIState(response)
    }

    fun getStarshipDetails(id: String) = viewModelScope.launch {
        val response = starshipsRepository.getStarshipDetails(id)

        _starshipDetailsResponse.value = convertToUIState(response)
    }
}