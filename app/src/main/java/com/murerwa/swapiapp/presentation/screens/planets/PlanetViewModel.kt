package com.murerwa.swapiapp.presentation.screens.planets

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murerwa.swapiapp.PlanetsQuery
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.domain.repository.PlanetsRepository
import com.murerwa.swapiapp.presentation.utils.convertToUIState
import kotlinx.coroutines.launch

class PlanetViewModel(
    private val planetsRepository: PlanetsRepository
) : ViewModel() {
    private val _planetsResponse: MutableState<UIState<PlanetsQuery.Data?>> = mutableStateOf(
        UIState.Loading)
    val planetsResponse = _planetsResponse

    fun getPlanets() = viewModelScope.launch {
        val response = planetsRepository.getPlanets()

        _planetsResponse.value = convertToUIState(response)
    }
}