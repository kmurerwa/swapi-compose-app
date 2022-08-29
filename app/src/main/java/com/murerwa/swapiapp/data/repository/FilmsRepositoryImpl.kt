package com.murerwa.swapiapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.exception.ApolloException
import com.murerwa.swapiapp.FilmsQuery
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import timber.log.Timber

class FilmsRepositoryImpl(
    private val apolloClient: ApolloClient
): FilmsRepository {
    override suspend fun getFilms(): FilmsQuery.Data? {
        val response = apolloClient.query(FilmsQuery()).execute()

        return response.data
    }

}