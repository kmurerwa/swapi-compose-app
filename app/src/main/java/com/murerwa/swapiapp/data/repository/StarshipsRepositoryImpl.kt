package com.murerwa.swapiapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.StarshipDetailsQuery
import com.murerwa.swapiapp.StarshipsQuery
import com.murerwa.swapiapp.data.network.BaseRepository
import com.murerwa.swapiapp.data.network.NetworkResult
import com.murerwa.swapiapp.domain.repository.StarshipsRepository

class StarshipsRepositoryImpl(
    private val apolloClient: ApolloClient
): StarshipsRepository, BaseRepository() {
    override suspend fun getStarships(): NetworkResult<ApolloResponse<StarshipsQuery.Data>> {
        return safeApiCall { apolloClient.query(StarshipsQuery()).execute() }
    }

    override suspend fun getStarshipDetails(id: String): NetworkResult<ApolloResponse<StarshipDetailsQuery.Data>> {
        return safeApiCall { apolloClient.query(StarshipDetailsQuery(id)).execute() }
    }
}