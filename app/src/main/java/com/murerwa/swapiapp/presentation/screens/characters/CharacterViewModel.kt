package com.murerwa.swapiapp.presentation.screens.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murerwa.swapiapp.CharacterDetailsQuery
import com.murerwa.swapiapp.CharactersQuery
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.domain.repository.CharactersRepository
import com.murerwa.swapiapp.presentation.utils.convertToUIState
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val charactersRepository: CharactersRepository
): ViewModel() {
    private val _charactersResponse: MutableState<UIState<CharactersQuery.Data?>> = mutableStateOf(
        UIState.Loading)
    val charactersResponse = _charactersResponse

    private val _characterDetailsResponse: MutableState<UIState<CharacterDetailsQuery.Data?>> = mutableStateOf(
        UIState.Loading)
    val characterDetailsResponse = _characterDetailsResponse

    fun getCharacters() = viewModelScope.launch {
        val response = charactersRepository.getCharacters()

        _charactersResponse.value = convertToUIState(response)
    }

    fun getCharacterDetails(characterId: String) = viewModelScope.launch {
        val response = charactersRepository.getCharacterDetails(characterId)

        _characterDetailsResponse.value = convertToUIState(response)
    }

}