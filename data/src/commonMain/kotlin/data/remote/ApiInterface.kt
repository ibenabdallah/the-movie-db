package data.remote

import data.model.NetworkMovies
import data.model.details.NetworkMovieDetails
import data.model.NetworkMovieItem
import io.ktor.client.statement.HttpResponse

internal interface ApiInterface {

    suspend fun nowPlayingMovieList(page: Int): NetworkMovies<NetworkMovieItem>

    suspend fun topRatedMovieList(page: Int): NetworkMovies<NetworkMovieItem>

    suspend fun popularMovieList(page: Int): NetworkMovies<NetworkMovieItem>

    suspend fun upcomingMovieList(page: Int): NetworkMovies<NetworkMovieItem>

    suspend fun movieDetail(movieId: Int): HttpResponse
}