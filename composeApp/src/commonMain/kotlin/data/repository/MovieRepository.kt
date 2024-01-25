package data.repository

import androidx.paging.PagingSource
import data.DataState
import data.model.MovieItem
import kotlinx.coroutines.flow.Flow
import data.model.details.MovieDetails

interface MovieRepository {

    fun nowPlayingMovie(): PagingSource<Int, MovieItem>

    fun topRatedMovie(): PagingSource<Int, MovieItem>

    fun popularMovie(): PagingSource<Int, MovieItem>

    fun upComingMovie(): PagingSource<Int, MovieItem>

    fun movieDetail(movieId: Int): Flow<DataState<MovieDetails>>
}