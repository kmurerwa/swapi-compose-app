package com.murerwa.swapiapp.domain.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.PlanetsQuery
import com.murerwa.swapiapp.data.network.NetworkResult

interface PlanetsRepository {
    suspend fun getPlanets(): NetworkResult<ApolloResponse<PlanetsQuery.Data>>
}