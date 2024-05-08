package domain.mapper

import data.model.MovieEntity
import model.MovieItem

interface MovieMapper {
     fun map(movie: MovieEntity): MovieItem
}