package domain

import data.model.MovieItem
import data.paging.PaginatedContent

interface AllUpcomingMovieUseCase {
    operator fun invoke(): PaginatedContent<MovieItem>
}