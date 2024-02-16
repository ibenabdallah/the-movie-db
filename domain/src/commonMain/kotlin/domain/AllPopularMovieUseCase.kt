package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent

interface AllPopularMovieUseCase {
    operator fun invoke(): PaginatedContent<NetworkMovieItem>
}