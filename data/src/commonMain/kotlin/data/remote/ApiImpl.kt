package data.remote

import data.AppConfig
import data.ResponseError
import data.model.MovieEntity
import data.model.MoviesEntity
import data.model.details.MovieDetailsEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.serialization.json.Json

internal class ApiImpl(private val client: HttpClient) : ApiInterface {

    override suspend fun nowPlayingMovieList(page: Int): MoviesEntity<MovieEntity> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_NOW_PLAYING, page)
        }.body()
    }

    override suspend fun topRatedMovieList(page: Int): MoviesEntity<MovieEntity> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_TOP_RATED, page)
        }.body()
    }

    override suspend fun popularMovieList(page: Int): MoviesEntity<MovieEntity> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_POPULAR, page)
        }.body()
    }

    override suspend fun upcomingMovieList(page: Int): MoviesEntity<MovieEntity> {
        return client.get {
            uRLBuilderMovie(AppConfig.PATH_MOVIE_UPCOMING, page)
        }.body()
    }

    override suspend fun movieDetail(movieId: Int): DataResult<MovieDetailsEntity> {
        return safeExecute {
            client.get { movieDetail(movieId) }
        }
    }

    private suspend inline fun <reified T> safeExecute(
        block: () -> HttpResponse,
    ): DataResult<T> {
        try {
            val body = block().body<T>()
            return DataResult.Success(body)
        } catch (e: ClientRequestException) {
            val errorString = e.response.body<String>()
            val responseError = Json.decodeFromString<ResponseError>(errorString)
            return DataResult.Failure(responseError)
        } catch (e: Exception) {
            return DataResult.Failure(e)
        }
    }
}