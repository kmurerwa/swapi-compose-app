package com.murerwa.swapiapp.presentation.screens.film

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.data.network.NetworkResult
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.data.network.readError
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class FilmViewModel(
    private val filmsRepository: FilmsRepository
): ViewModel() {

    private val _filmsResponse: MutableState<UIState<FilmsQuery.Data?>> = mutableStateOf(
        UIState.Loading)
    val filmsResponse = _filmsResponse

    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch {
            when (val response = filmsRepository.getFilms()) {
                is NetworkResult.Success -> {
                    val apolloResponse = response.value.data

                    _filmsResponse.value = UIState.Success(apolloResponse)
                }
                is NetworkResult.Failure -> {
                    if (response.isNetworkError) {
                        _filmsResponse.value = UIState.Error("Network error")
                    } else {
                        if (response.errorBody != null) {
                            Timber.d("Response is Not Null")
                            val error = response.errorBody.readError()
                            if (!error.isNullOrEmpty()) {
                                _filmsResponse.value = UIState.Error(error)
                            } else {
                                _filmsResponse.value = UIState.Error("Error fetching films")
                            }

                        } else {
                            Timber.d("Response is Null")
                            _filmsResponse.value = UIState.Error("Error fetching films")
                        }
                    }
                }
            }
        }
    }
}