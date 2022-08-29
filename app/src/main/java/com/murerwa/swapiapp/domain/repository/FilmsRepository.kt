package com.murerwa.swapiapp.domain.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.data.network.NetworkResult

interface FilmsRepository {
    suspend fun getFilms(): NetworkResult<ApolloResponse<FilmsQuery.Data>>
}