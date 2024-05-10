package domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import model.MovieItem

interface AllTopRatedMovieUseCase {
    operator fun invoke(): Flow<PagingData<MovieItem>>
}