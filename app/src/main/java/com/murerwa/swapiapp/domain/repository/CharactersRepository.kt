package com.murerwa.swapiapp.domain.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.CharacterDetailsQuery
import com.murerwa.swapiapp.CharactersQuery
import com.murerwa.swapiapp.data.network.NetworkResult

interface CharactersRepository {
    suspend fun getCharacters(): NetworkResult<ApolloResponse<CharactersQuery.Data>>
    suspend fun getCharacterDetails(id: String): NetworkResult<ApolloResponse<CharacterDetailsQuery.Data>>
}