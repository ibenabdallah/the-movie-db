package data.repository

import androidx.paging.PagingSource
import data.DataState
import data.Status
import data.model.MovieItem
import data.model.details.MovieDetails
import data.paging.MoviePagingSource
import data.remote.ApiInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val api: ApiInterface) : MovieRepository {

    override fun nowPlayingMovie(): PagingSource<Int, MovieItem> {
        return MoviePagingSource { page ->
            api.nowPlayingMovieList(page)
        }
    }

    override fun topRatedMovie(): PagingSource<Int, MovieItem> {
        return MoviePagingSource { page ->
            api.topRatedMovieList(page)
        }
    }

    override fun popularMovie(): PagingSource<Int, MovieItem> {
        return MoviePagingSource { page ->
            api.popularMovieList(page)
        }
    }

    override fun upComingMovie(): PagingSource<Int, MovieItem> {
        return MoviePagingSource { page ->
            api.upcomingMovieList(page)
        }
    }

    override fun movieDetail(movieId: Int): Flow<DataState<MovieDetails>> = flow {
        emit(DataState.Loading)
        try {
            val data = when (val response = api.movieDetail(movieId)) {
                is Status.Success -> DataState.Success(response.data)
                is Status.Error -> DataState.Error(response.error)
            }
            emit(data)
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
