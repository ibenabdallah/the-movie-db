package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent
import domain.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllNowPlayingMovieUseCaseImpl(private val repository: MovieRepository) :
    AllNowPlayingMovieUseCase {

    override operator fun invoke(): PaginatedContent<NetworkMovieItem> {
        return PaginatedContentImpl { repository.nowPlayingMovie() }
    }

}