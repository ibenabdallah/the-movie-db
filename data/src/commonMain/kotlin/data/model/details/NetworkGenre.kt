package data.model.details

import kotlinx.serialization.Serializable
import model.BelongsToCollection
import model.Genre

@Serializable
data class NetworkGenre(
    val id: Int?,
    val name: String
)


fun NetworkGenre.asExternalModel() = Genre(
    id = id,
    name = name
)