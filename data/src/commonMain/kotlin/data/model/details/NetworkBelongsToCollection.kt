package data.model.details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.BelongsToCollection

@Serializable
data class NetworkBelongsToCollection(
    val id: Int,
    val name: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("backdrop_path")
    val backdropPath: String?,
)

fun NetworkBelongsToCollection.asExternalModel() = BelongsToCollection(
    id = id,
    name = name,
    posterPath = posterPath,
    backdropPath = backdropPath
)