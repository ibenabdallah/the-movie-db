package data.remote

import data.AppConfig
import data.model.details.NetworkMovieDetails
import data.model.NetworkMovieItem
import data.model.NetworkMovies
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ApiImpl(private val client: HttpClient) : ApiInterface {

    override suspend fun nowPlayingMovieList(page: Int): NetworkMovies<NetworkMovieItem> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_NOW_PLAYING, page)
        }.body()
    }

    override suspend fun topRatedMovieList(page: Int): NetworkMovies<NetworkMovieItem> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_TOP_RATED, page)
        }.body()
    }

    override suspend fun popularMovieList(page: Int): NetworkMovies<NetworkMovieItem> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_POPULAR, page)
        }.body()
    }

    override suspend fun upcomingMovieList(page: Int): NetworkMovies<NetworkMovieItem> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_UPCOMING, page)
        }.body()
    }

    override suspend fun movieDetail(movieId: Int): NetworkMovieDetails {
        return client.get {
            movieDetail(movieId)
        }.body()
    }
}