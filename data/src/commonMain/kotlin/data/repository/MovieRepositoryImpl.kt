package data.repository

import androidx.paging.PagingSource
import data.model.NetworkMovieItem
import data.paging.MoviePagingSource
import data.remote.ApiInterface

internal class MovieRepositoryImpl(private val api: ApiInterface) : MovieRepository {

    override fun nowPlayingMovie(): PagingSource<Int, NetworkMovieItem> {
        return MoviePagingSource { page ->
            api.nowPlayingMovieList(page)
        }
    }

    override fun topRatedMovie(): PagingSource<Int, NetworkMovieItem> {
        return MoviePagingSource { page ->
            api.topRatedMovieList(page)
        }
    }

    override fun popularMovie(): PagingSource<Int, NetworkMovieItem> {
        return MoviePagingSource { page ->
            api.popularMovieList(page)
        }
    }

    override fun upComingMovie(): PagingSource<Int, NetworkMovieItem> {
        return MoviePagingSource { page ->
            api.upcomingMovieList(page)
        }
    }
}
