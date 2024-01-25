package domain

import data.model.MovieItem
import data.paging.PaginatedContent
import data.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllNowPlayingMovieUseCaseImpl(private val repository: MovieRepository) :
    AllNowPlayingMovieUseCase {

    override operator fun invoke(): PaginatedContent<MovieItem> {
        return PaginatedContentImpl { repository.nowPlayingMovie() }
    }

}