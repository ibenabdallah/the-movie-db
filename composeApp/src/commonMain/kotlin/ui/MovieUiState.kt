package ui

sealed interface MovieUiState<T> {

    /**
     * The state is loading.
     */
    data object Loading : MovieUiState<Nothing>

    /**
     * The state was unable to load.
     */
    data class Failed(val exception: Throwable = Throwable()) : MovieUiState<Nothing>

    /**
     * There is a success state, with the given data.
     */
    data class Success<T>(val data: T) : MovieUiState<T>
}