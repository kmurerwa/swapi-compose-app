package com.murerwa.swapiapp.presentation.utils

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Operation
import com.murerwa.swapiapp.data.network.NetworkResult
import com.murerwa.swapiapp.data.network.UIState
import com.murerwa.swapiapp.data.network.readError
import timber.log.Timber

fun <T : Operation.Data> convertToUIState(response: NetworkResult<ApolloResponse<T>>): UIState<T?> {
    return when (response) {
        is NetworkResult.Success -> {
            UIState.Success(response.value.data)
        }
        is NetworkResult.Failure -> {
            if (response.isNetworkError) {
                UIState.Error("Network error")
            } else {
                if (response.errorBody != null) {
                    Timber.d("Response is Not Null")
                    val error = response.errorBody.readError()
                    if (!error.isNullOrEmpty()) {
                        UIState.Error(error)
                    } else {
                        UIState.Error("Error processing your request")
                    }

                } else {
                    Timber.d("Response is Null")
                    UIState.Error("Error processing your request")
                }
            }
        }
    }
}