package com.murerwa.swapiapp.data.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.google.gson.GsonBuilder
import com.murerwa.swapiapp.data.network.Urls
import com.murerwa.swapiapp.data.repository.FilmsRepositoryImpl
import com.murerwa.swapiapp.domain.repository.FilmsRepository
import com.murerwa.swapiapp.presentation.di.presentationModules
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private val repositoryModules: Module = module {
    single <FilmsRepository> { FilmsRepositoryImpl(get()) }
}

private val networkingModules: Module = module {
    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = when (BuildConfig.BUILD_TYPE) {
            "release" -> HttpLoggingInterceptor.Level.NONE
            else -> HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit> {
        val gson = GsonBuilder()
            .serializeNulls()
            .create()

        Retrofit.Builder()
            .baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get())
            .build()
    }

    single {
        ApolloClient.Builder()
            .serverUrl(Urls.BASE_URL)
            .okHttpClient(get())
            .build()
    }
}

val apiModules: Module = module {
//    single<ApiClient> { get<Retrofit>().create(ApiClient::class.java) }
}

val dataModules: List<Module> = listOf(
    repositoryModules,
    networkingModules,
    apiModules,
)
