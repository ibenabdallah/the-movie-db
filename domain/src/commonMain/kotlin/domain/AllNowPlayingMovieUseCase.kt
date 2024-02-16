package domain

import data.model.NetworkMovieItem
import domain.paging.PaginatedContent

interface AllNowPlayingMovieUseCase {
    operator fun invoke(): PaginatedContent<NetworkMovieItem>
}