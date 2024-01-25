package data.model.details

import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    val id: Int?,
    val name: String
)