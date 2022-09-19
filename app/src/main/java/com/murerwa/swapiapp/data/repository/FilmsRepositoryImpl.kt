package com.murerwa.swapiapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.exception.ApolloException
import com.murerwa.swapiapp.FilmDetailsQuery
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.data.network.BaseRepository
import com.murerwa.swapiapp.data.network.NetworkResult
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import timber.log.Timber

class FilmsRepositoryImpl(
    private val apolloClient: ApolloClient
): FilmsRepository, BaseRepository() {
    override suspend fun getFilms(): NetworkResult<ApolloResponse<FilmsQuery.Data>> {
        return safeApiCall { apolloClient.query(FilmsQuery()).execute() }
    }

    override suspend fun getFilmDetails(id: String): NetworkResult<ApolloResponse<FilmDetailsQuery.Data>> {
        return safeApiCall { apolloClient.query(FilmDetailsQuery(id)).execute() }
    }

}