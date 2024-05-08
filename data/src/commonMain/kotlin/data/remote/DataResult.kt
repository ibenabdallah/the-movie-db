package data.remote

sealed interface DataResult<out T> {
    data class Success<T>(val data: T) : DataResult<T>
    data class Failure(val exception: Throwable) : DataResult<Nothing>
}