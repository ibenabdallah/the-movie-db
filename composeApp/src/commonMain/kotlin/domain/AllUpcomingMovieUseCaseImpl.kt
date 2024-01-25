package domain

import data.model.MovieItem
import data.paging.PaginatedContent
import data.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllUpcomingMovieUseCaseImpl(private val repository: MovieRepository) :
    AllUpcomingMovieUseCase {

    override operator fun invoke(): PaginatedContent<MovieItem> {
        return PaginatedContentImpl { repository.upComingMovie() }
    }
}