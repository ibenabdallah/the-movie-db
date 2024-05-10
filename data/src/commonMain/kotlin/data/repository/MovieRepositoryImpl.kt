package data.repository

import androidx.paging.PagingSource
import data.model.MovieEntity
import data.paging.MoviePagingSource
import data.remote.ApiInterface

internal class MovieRepositoryImpl(private val api: ApiInterface) : MovieRepository {

    override fun nowPlayingMovie(): PagingSource<Int, MovieEntity> {
        return MoviePagingSource { page ->
            api.nowPlayingMovieList(page)
        }
    }

    override fun topRatedMovie(): PagingSource<Int, MovieEntity> {
        return MoviePagingSource { page ->
            api.topRatedMovieList(page)
        }
    }

    override fun popularMovie(): PagingSource<Int, MovieEntity> {
        return MoviePagingSource { page ->
            api.popularMovieList(page)
        }
    }

    override fun upComingMovie(): PagingSource<Int, MovieEntity> {
        return MoviePagingSource { page ->
            api.upcomingMovieList(page)
        }
    }
}
