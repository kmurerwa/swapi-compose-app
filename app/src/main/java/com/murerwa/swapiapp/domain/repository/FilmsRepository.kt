package com.murerwa.swapiapp.domain.repository

interface FilmsRepository {
    suspend fun getFilms()
}