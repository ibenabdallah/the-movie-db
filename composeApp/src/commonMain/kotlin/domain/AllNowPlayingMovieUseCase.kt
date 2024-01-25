package domain

import app.cash.paging.Pager
import data.model.MovieItem
import data.paging.PaginatedContent

interface AllNowPlayingMovieUseCase {
    operator fun invoke(): PaginatedContent<MovieItem>
}