package data

sealed class Status<T> {
    data class Success<T>(val data: T) : Status<T>()
    data class Error<T>(val error: Exception = Exception()) : Status<T>()
}


/**
 * Data state for processing api response Loading, Success and Error
 */
sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}