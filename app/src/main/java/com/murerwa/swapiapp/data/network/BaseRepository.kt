package com.murerwa.swapiapp.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber

open class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Timber.d(throwable.toString())
                when (throwable) {
                    is HttpException -> {
                        NetworkResult.Failure(
                            isNetworkError = false,
                            throwable.code(),
                            throwable.response()?.errorBody()
                        )
                    }
                    else -> {
                        NetworkResult.Failure(true, null, null)
                    }
                }
            }
        }
    }
}