package domain

import kotlinx.coroutines.flow.Flow
import model.MovieDetails
import result.DomainResult

interface MovieDetailsUseCase {
    operator fun invoke(movieId: Int): Flow<DomainResult<MovieDetails>>
}