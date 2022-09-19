package com.murerwa.swapiapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.murerwa.swapiapp.CharacterDetailsQuery
import com.murerwa.swapiapp.CharactersQuery
import com.murerwa.swapiapp.data.network.BaseRepository
import com.murerwa.swapiapp.data.network.NetworkResult
import com.murerwa.swapiapp.domain.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val apolloClient: ApolloClient
): CharactersRepository, BaseRepository() {
    override suspend fun getCharacters(): NetworkResult<ApolloResponse<CharactersQuery.Data>> {
        return safeApiCall { apolloClient.query(CharactersQuery()).execute() }
    }

    override suspend fun getCharacterDetails(id: String): NetworkResult<ApolloResponse<CharacterDetailsQuery.Data>> {
        return safeApiCall { apolloClient.query(CharacterDetailsQuery(id)).execute() }
    }
}