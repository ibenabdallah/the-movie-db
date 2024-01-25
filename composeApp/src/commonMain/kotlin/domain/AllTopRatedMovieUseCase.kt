package domain

import data.model.MovieItem
import data.paging.PaginatedContent

interface AllTopRatedMovieUseCase {
    operator fun invoke(): PaginatedContent<MovieItem>
}