package data.model.details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.ProductionCountry

@Serializable
data class NetworkProductionCountry(
    @SerialName("iso_3166_1")
    val iso31661: String,
    val name: String
)

fun NetworkProductionCountry.asExternalModel() = ProductionCountry(
    iso31661 = iso31661,
    name = name
)