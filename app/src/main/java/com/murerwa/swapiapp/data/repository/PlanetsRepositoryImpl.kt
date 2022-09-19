package com.murerwa.swapiapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.PlanetsQuery
import com.murerwa.swapiapp.data.network.BaseRepository
import com.murerwa.swapiapp.data.network.NetworkResult
import com.murerwa.swapiapp.domain.repository.PlanetsRepository

class PlanetsRepositoryImpl(
    private val apolloClient: ApolloClient
): PlanetsRepository, BaseRepository() {
    override suspend fun getPlanets(): NetworkResult<ApolloResponse<PlanetsQuery.Data>> {
        return safeApiCall { apolloClient.query(PlanetsQuery()).execute() }
    }
}