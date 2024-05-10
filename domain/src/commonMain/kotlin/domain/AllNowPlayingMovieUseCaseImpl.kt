package domain

import androidx.paging.PagingData
import androidx.paging.map
import data.repository.MovieRepository
import domain.mapper.MovieMapper
import domain.paging.PaginatedContentImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.MovieItem

class AllNowPlayingMovieUseCaseImpl(
    private val repository: MovieRepository,
    private val mapper: MovieMapper,
) :
    AllNowPlayingMovieUseCase {

    override operator fun invoke(): Flow<PagingData<MovieItem>> {
        return PaginatedContentImpl { repository.nowPlayingMovie() }
            .flow.map { pagingData ->
                pagingData.map { mapper.map(it) }
            }
    }

}