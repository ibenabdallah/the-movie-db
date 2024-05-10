package domain.mapper

import data.model.MovieEntity
import model.MovieItem

class MovieMapperImpl : MovieMapper {
    override fun map(movie: MovieEntity): MovieItem {
        return MovieItem(
            id = movie.id,
            adult = movie.adult,
            backdropPath = movie.backdropPath,
            genreIds = movie.genreIds,
            originalLanguage = movie.originalLanguage,
            originalTitle = movie.originalTitle,
            overview = movie.overview,
            popularity = movie.popularity,
            posterPath = movie.posterPath,
            releaseDate = movie.releaseDate,
            title = movie.title,
            video = movie.video,
            voteAverage = movie.voteAverage,
            voteCount = movie.voteCount
        )
    }

}