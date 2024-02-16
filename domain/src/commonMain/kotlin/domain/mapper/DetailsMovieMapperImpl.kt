package domain.mapper

import data.model.details.NetworkGenre
import data.model.details.NetworkMovieDetails
import data.model.details.NetworkProductionCompany
import data.model.details.NetworkProductionCountry
import data.model.details.NetworkSpokenLanguage
import data.model.details.asExternalModel
import model.MovieDetails

class DetailsMovieMapperImpl : DetailsMovieMapper {
    override operator fun invoke(movie: NetworkMovieDetails): MovieDetails {
        return MovieDetails(
            adult = movie.adult,
            backdropPath = movie.backdropPath,
            belongsToCollection = movie.belongsToCollection?.asExternalModel(),
            budget = movie.budget,
            genres = movie.genres.map(NetworkGenre::asExternalModel),
            homepage = movie.homepage,
            id = movie.id,
            imdbId = movie.imdbId,
            originalLanguage = movie.originalLanguage,
            originalTitle = movie.originalTitle,
            overview = movie.overview,
            popularity = movie.popularity,
            posterPath = movie.posterPath,
            productionCompanies = movie.productionCompanies.map(NetworkProductionCompany::asExternalModel),
            productionCountries = movie.productionCountries.map(NetworkProductionCountry::asExternalModel),
            releaseDate = movie.releaseDate,
            revenue = movie.revenue,
            runtime = movie.runtime,
            spokenLanguages = movie.spokenLanguages.map(NetworkSpokenLanguage::asExternalModel),
            status = movie.status,
            tagline = movie.tagline,
            title = movie.title,
            video = movie.video,
            voteAverage = movie.voteAverage,
            voteCount = movie.voteCount
        )
    }
}