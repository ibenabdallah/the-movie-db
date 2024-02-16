package data.repository

import androidx.paging.PagingSource
import data.model.NetworkMovieItem

interface MovieRepository {

    fun nowPlayingMovie(): PagingSource<Int, NetworkMovieItem>

    fun topRatedMovie(): PagingSource<Int, NetworkMovieItem>

    fun popularMovie(): PagingSource<Int, NetworkMovieItem>

    fun upComingMovie(): PagingSource<Int, NetworkMovieItem>

}