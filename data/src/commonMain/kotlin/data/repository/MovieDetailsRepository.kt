package data.repository

import data.model.details.NetworkMovieDetails

interface MovieDetailsRepository {
    suspend fun movieDetail(movieId: Int): NetworkMovieDetails
}