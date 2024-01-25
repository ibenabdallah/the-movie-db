package domain

import data.model.MovieItem
import data.paging.PaginatedContent
import data.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllTopRatedMovieUseCaseImpl(private val repository: MovieRepository) :
    AllTopRatedMovieUseCase {

    override operator fun invoke(): PaginatedContent<MovieItem> {
        return PaginatedContentImpl { repository.topRatedMovie() }
    }

}