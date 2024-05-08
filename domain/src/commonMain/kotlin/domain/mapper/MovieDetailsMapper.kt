package domain.mapper

import data.model.details.MovieDetailsEntity
import data.remote.DataResult
import model.MovieDetails
import result.DomainResult

interface MovieDetailsMapper {
     fun map(movie: DataResult<MovieDetailsEntity>): DomainResult<MovieDetails>
}