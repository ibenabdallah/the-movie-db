package domain

import kotlinx.coroutines.flow.Flow
import model.MovieDetails

interface DetailsMovieUseCase {
    operator fun invoke(movieId: Int): Flow<MovieDetails>
}