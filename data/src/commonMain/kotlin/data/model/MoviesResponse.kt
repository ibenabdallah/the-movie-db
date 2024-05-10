package data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MoviesEntity<T>(
    val page: Int,
    val results: List<T>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int,
    val dates: DatesEntity? = null,
)