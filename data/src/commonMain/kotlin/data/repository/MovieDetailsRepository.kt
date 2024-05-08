package data.repository

import data.model.details.MovieDetailsEntity
import data.remote.DataResult

interface MovieDetailsRepository {
    suspend fun movieDetail(movieId: Int): DataResult<MovieDetailsEntity>
}