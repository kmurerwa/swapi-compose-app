package com.murerwa.swapiapp.data.repository

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import retrofit2.http.Query
import timber.log.Timber

class FilmsRepositoryImpl(
    private val apolloClient: ApolloClient
): FilmsRepository {
    override suspend fun getFilms() {
//        val response = try {
////            client.query().execute()
//            apolloClient.query(FilmsQuery)
//        }catch (e : ApolloException){
//            Timber.d("Error: ${e.message}")
//        }
    }

}