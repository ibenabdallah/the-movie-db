package data.model.details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.SpokenLanguage

@Serializable
data class NetworkSpokenLanguage(
    @SerialName("english_name")
    val englishName: String,
    @SerialName("iso_639_1")
    val iso6391: String,
    val name: String,
)

fun NetworkSpokenLanguage.asExternalModel() = SpokenLanguage(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)