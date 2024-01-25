package domain

import data.DataState
import data.model.details.MovieDetails
import data.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class DetailsMovieUseCaseImpl(private val repository: MovieRepository) : DetailsMovieUseCase {
    override fun invoke(movieId: Int): Flow<DataState<MovieDetails>> {
        return repository.movieDetail(movieId)
    }
}