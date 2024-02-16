package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent

interface AllTopRatedMovieUseCase {
    operator fun invoke(): PaginatedContent<NetworkMovieItem>
}