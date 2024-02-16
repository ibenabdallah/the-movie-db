package domain

import data.repository.MovieDetailsRepository
import domain.mapper.DetailsMovieMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.MovieDetails

class DetailsMovieUseCaseImpl(
    private val repository: MovieDetailsRepository,
    private val mapper: DetailsMovieMapper,
) : DetailsMovieUseCase {
    override fun invoke(movieId: Int): Flow<MovieDetails> = flow {
        val movie = repository.movieDetail(movieId)
        val movieUi = mapper.invoke(movie)
        emit(movieUi)
    }
}