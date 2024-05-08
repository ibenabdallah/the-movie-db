package data.repository

import androidx.paging.PagingSource
import data.model.MovieEntity

interface MovieRepository {

    fun nowPlayingMovie(): PagingSource<Int, MovieEntity>

    fun topRatedMovie(): PagingSource<Int, MovieEntity>

    fun popularMovie(): PagingSource<Int, MovieEntity>

    fun upComingMovie(): PagingSource<Int, MovieEntity>

}