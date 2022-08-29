package com.murerwa.swapiapp.domain.repository

import com.murerwa.swapiapp.FilmsQuery

interface FilmsRepository {
    suspend fun getFilms(): FilmsQuery.Data?
}