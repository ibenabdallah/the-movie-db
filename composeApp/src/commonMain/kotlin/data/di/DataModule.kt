package data.di

import data.remote.httpClientImpl
import data.remote.ApiImpl
import data.remote.ApiInterface
import data.repository.MovieRepository
import data.repository.MovieRepositoryImpl
import io.ktor.client.HttpClient
import org.koin.dsl.module


val dataModule = module {

    single<HttpClient> { httpClientImpl() }

    single<ApiInterface> { ApiImpl(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get()) }

}