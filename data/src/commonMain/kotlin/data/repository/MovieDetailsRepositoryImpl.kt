package data.repository

import data.model.details.MovieDetailsEntity
import data.remote.ApiInterface
import data.remote.DataResult

internal class MovieDetailsRepositoryImpl(private val api: ApiInterface) : MovieDetailsRepository {

    override suspend fun movieDetail(movieId: Int): DataResult<MovieDetailsEntity> {
        return api.movieDetail(movieId)
    }
}
