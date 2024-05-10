package data.remote

import data.model.MoviesEntity
import data.model.MovieEntity
import data.model.details.MovieDetailsEntity

internal interface ApiInterface {

    suspend fun nowPlayingMovieList(page: Int): MoviesEntity<MovieEntity>

    suspend fun topRatedMovieList(page: Int): MoviesEntity<MovieEntity>

    suspend fun popularMovieList(page: Int): MoviesEntity<MovieEntity>

    suspend fun upcomingMovieList(page: Int): MoviesEntity<MovieEntity>

    suspend fun movieDetail(movieId: Int): DataResult<MovieDetailsEntity>
}