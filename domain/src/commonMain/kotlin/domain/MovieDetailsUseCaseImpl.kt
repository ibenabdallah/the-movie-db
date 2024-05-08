package domain

import data.repository.MovieDetailsRepository
import domain.mapper.MovieDetailsMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.MovieDetails
import result.DomainResult

class MovieDetailsUseCaseImpl(
    private val repository: MovieDetailsRepository,
    private val mapper: MovieDetailsMapper,
) : MovieDetailsUseCase {
    override fun invoke(movieId: Int): Flow<DomainResult<MovieDetails>> =
        flow {
            emit(repository.movieDetail(movieId).let {
                mapper.map(it)
            })
        }
}