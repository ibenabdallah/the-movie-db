package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent

interface AllUpcomingMovieUseCase {
    operator fun invoke(): PaginatedContent<NetworkMovieItem>
}