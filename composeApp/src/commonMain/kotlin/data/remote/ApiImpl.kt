package data.remote

import data.AppConfig
import data.Status
import data.model.details.MovieDetails
import data.model.MovieItem
import data.model.PaginatedMovie
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

class ApiImpl(private val client: HttpClient) : ApiInterface {

    override suspend fun nowPlayingMovieList(page: Int): Status<PaginatedMovie<MovieItem>> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_NOW_PLAYING, page)
        }.toStatus()
    }

    override suspend fun topRatedMovieList(page: Int): Status<PaginatedMovie<MovieItem>> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_TOP_RATED, page)
        }.toStatus()
    }

    override suspend fun popularMovieList(page: Int): Status<PaginatedMovie<MovieItem>> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_POPULAR, page)
        }.toStatus()
    }

    override suspend fun upcomingMovieList(page: Int): Status<PaginatedMovie<MovieItem>> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_UPCOMING, page)
        }.toStatus()
    }

    override suspend fun movieDetail(movieId: Int): Status<MovieDetails> {
        return client.get {
            movieDetail(movieId)
        }.toStatus()
    }

    private suspend inline fun <reified T> HttpResponse.toStatus(): Status<T> {
        return when {
            this.status.isSuccess() -> Status.Success(this.body<T>())
            else -> Status.Error()
        }
    }
}