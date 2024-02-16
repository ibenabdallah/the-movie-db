package data

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    val success: Boolean,
    val status_code: Int,
    val status_message: String,
) : Throwable()