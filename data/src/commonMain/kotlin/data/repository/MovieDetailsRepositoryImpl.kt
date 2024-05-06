package data.repository

import data.model.details.NetworkMovieDetails
import data.remote.ApiInterface
import io.ktor.client.call.body

internal class MovieDetailsRepositoryImpl(private val api: ApiInterface) : MovieDetailsRepository {

    override suspend fun movieDetail(movieId: Int): NetworkMovieDetails {
        return api.movieDetail(movieId).body()
    }
}
