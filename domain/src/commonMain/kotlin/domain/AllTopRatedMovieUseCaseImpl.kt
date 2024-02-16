package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent
import domain.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllTopRatedMovieUseCaseImpl(private val repository: MovieRepository) :
    AllTopRatedMovieUseCase {

    override operator fun invoke(): PaginatedContent<NetworkMovieItem> {
        return PaginatedContentImpl { repository.topRatedMovie() }
    }

}