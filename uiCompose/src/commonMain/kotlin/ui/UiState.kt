package ui

sealed interface UiState<T> {

    /**
     * The state is loading.
     */
    data object Loading : UiState<Nothing>

    /**
     * The state was unable to load.
     */
    data class Failure(val exception: Throwable = Throwable()) : UiState<Nothing>

    /**
     * There is a success state, with the given data.
     */
    data class Success<T>(val data: T) : UiState<T>
}