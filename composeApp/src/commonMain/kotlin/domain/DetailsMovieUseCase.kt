package domain

import data.DataState
import data.model.details.MovieDetails
import kotlinx.coroutines.flow.Flow

interface DetailsMovieUseCase {
    operator fun invoke(movieId: Int): Flow<DataState<MovieDetails>>
}