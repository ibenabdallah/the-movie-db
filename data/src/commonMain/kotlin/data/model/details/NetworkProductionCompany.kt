package data.model.details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.ProductionCompany

@Serializable
data class NetworkProductionCompany(
    val id: Int,
    val name: String,
    @SerialName("logo_path")
    val logoPath: String?,
    @SerialName("origin_country")
    val originCountry: String,
)

fun NetworkProductionCompany.asExternalModel() = ProductionCompany(
    id = id,
    name = name,
    logoPath = logoPath,
    originCountry = originCountry
)