package domain

import data.model.MovieItem
import data.paging.PaginatedContent
import data.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllPopularMovieUseCaseImpl(private val repository: MovieRepository) : AllPopularMovieUseCase {

    override operator fun invoke(): PaginatedContent<MovieItem> {
        return PaginatedContentImpl { repository.popularMovie() }
    }

}