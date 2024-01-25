package data.remote

import data.Status
import data.model.PaginatedMovie
import data.model.details.MovieDetails
import data.model.MovieItem

interface ApiInterface {

    suspend fun nowPlayingMovieList(page: Int): Status<PaginatedMovie<MovieItem>>

    suspend fun topRatedMovieList(page: Int): Status<PaginatedMovie<MovieItem>>

    suspend fun popularMovieList(page: Int): Status<PaginatedMovie<MovieItem>>

    suspend fun upcomingMovieList(page: Int): Status<PaginatedMovie<MovieItem>>

    suspend fun movieDetail(movieId: Int): Status<MovieDetails>
}