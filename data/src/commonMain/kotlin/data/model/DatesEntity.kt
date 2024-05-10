package data.model

import kotlinx.serialization.Serializable

@Serializable
data class DatesEntity(
    val maximum: String,
    val minimum: String,
)
