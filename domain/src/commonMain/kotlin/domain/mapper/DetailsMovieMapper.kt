package domain.mapper

import data.model.details.NetworkMovieDetails
import model.MovieDetails

interface DetailsMovieMapper {
    operator fun invoke(movie: NetworkMovieDetails): MovieDetails
}