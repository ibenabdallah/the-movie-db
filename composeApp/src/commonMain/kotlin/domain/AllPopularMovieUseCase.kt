package domain

import data.model.MovieItem
import data.paging.PaginatedContent

interface AllPopularMovieUseCase {
    operator fun invoke(): PaginatedContent<MovieItem>
}