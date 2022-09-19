package com.murerwa.swapiapp.domain.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.StarshipDetailsQuery
import com.murerwa.swapiapp.StarshipsQuery
import com.murerwa.swapiapp.data.network.NetworkResult

interface StarshipsRepository {
    suspend fun getStarships(): NetworkResult<ApolloResponse<StarshipsQuery.Data>>
    suspend fun getStarshipDetails(id: String): NetworkResult<ApolloResponse<StarshipDetailsQuery.Data>>
}