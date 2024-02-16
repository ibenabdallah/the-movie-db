package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent
import domain.paging.PaginatedContentImpl
import data.repository.MovieRepository

class AllUpcomingMovieUseCaseImpl(private val repository: MovieRepository) :
    AllUpcomingMovieUseCase {

    override operator fun invoke(): PaginatedContent<NetworkMovieItem> {
        return PaginatedContentImpl { repository.upComingMovie() }
    }
}