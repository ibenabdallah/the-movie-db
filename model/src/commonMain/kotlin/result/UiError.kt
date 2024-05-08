package result


data class UiError(
    val success: Boolean,
    val code: Int,
    override val message: String,
) : Throwable()