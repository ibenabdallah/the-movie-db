package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent
import domain.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllPopularMovieUseCaseImpl(private val repository: MovieRepository) : AllPopularMovieUseCase {

    override operator fun invoke(): PaginatedContent<NetworkMovieItem> {
        return PaginatedContentImpl { repository.popularMovie() }
    }

}