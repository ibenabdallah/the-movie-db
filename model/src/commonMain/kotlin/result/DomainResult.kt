package result

sealed interface DomainResult<out T> {
    data class Success<T>(val data: T) : DomainResult<T>
    data class Failure(val exception: Throwable) : DomainResult<Nothing>
}