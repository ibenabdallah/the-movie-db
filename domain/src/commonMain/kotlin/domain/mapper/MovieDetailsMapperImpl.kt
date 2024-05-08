package domain.mapper

import data.ResponseError
import data.model.details.BelongsToCollectionEntity
import data.model.details.GenreEntity
import data.model.details.MovieDetailsEntity
import data.model.details.ProductionCompanyEntity
import data.model.details.ProductionCountryEntity
import data.model.details.SpokenLanguageEntity
import data.remote.DataResult
import model.BelongsToCollection
import model.Genre
import model.MovieDetails
import result.DomainResult
import model.ProductionCompany
import model.ProductionCountry
import model.SpokenLanguage
import result.UiError

class MovieDetailsMapperImpl : MovieDetailsMapper {
    override fun map(movie: DataResult<MovieDetailsEntity>): DomainResult<MovieDetails> {
        return when (movie) {
            is DataResult.Success -> DomainResult.Success(
                MovieDetails(
                    adult = movie.data.adult,
                    backdropPath = movie.data.backdropPath,
                    belongsToCollection = movie.data.belongsToCollection?.asExternalModel(),
                    budget = movie.data.budget,
                    genres = movie.data.genres.map { it.asExternalModel() },
                    homepage = movie.data.homepage,
                    id = movie.data.id,
                    imdbId = movie.data.imdbId,
                    originalLanguage = movie.data.originalLanguage,
                    originalTitle = movie.data.originalTitle,
                    overview = movie.data.overview,
                    popularity = movie.data.popularity,
                    posterPath = movie.data.posterPath,
                    productionCompanies = movie.data.productionCompanies.map { it.asExternalModel() },
                    productionCountries = movie.data.productionCountries.map { it.asExternalModel() },
                    releaseDate = movie.data.releaseDate,
                    revenue = movie.data.revenue,
                    runtime = movie.data.runtime,
                    spokenLanguages = movie.data.spokenLanguages.map { it.asExternalModel() },
                    status = movie.data.status,
                    tagline = movie.data.tagline,
                    title = movie.data.title,
                    video = movie.data.video,
                    voteAverage = movie.data.voteAverage,
                    voteCount = movie.data.voteCount
                )
            )

            is DataResult.Failure -> when (val error = movie.exception) {
                is ResponseError -> DomainResult.Failure(
                    UiError(
                        success = error.success,
                        code = error.status_code,
                        message = error.status_message
                    )
                )

                else -> DomainResult.Failure(movie.exception)
            }
        }
    }

    private fun BelongsToCollectionEntity.asExternalModel() = BelongsToCollection(
        id = id,
        name = name,
        posterPath = posterPath,
        backdropPath = backdropPath
    )

    private fun GenreEntity.asExternalModel() = Genre(
        id = id,
        name = name
    )

    private fun ProductionCompanyEntity.asExternalModel() = ProductionCompany(
        id = id,
        name = name,
        logoPath = logoPath,
        originCountry = originCountry
    )

    private fun ProductionCountryEntity.asExternalModel() = ProductionCountry(
        iso31661 = iso31661,
        name = name
    )

    private fun SpokenLanguageEntity.asExternalModel() = SpokenLanguage(
        englishName = englishName,
        iso6391 = iso6391,
        name = name
    )
}