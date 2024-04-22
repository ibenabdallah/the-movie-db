package ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ui.asResult
import ui.Result
import domain.DetailsMovieUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import model.MovieDetails
import ui.MovieUiState

class MovieDetailViewModel(private val useCase: DetailsMovieUseCase) : ViewModel() {

    fun movieDetail(movieId: Int): StateFlow<MovieUiState<out MovieDetails>> {

        return useCase.invoke(movieId)
            .asResult()
            .map { followedMovieDetailsResult ->
                when (followedMovieDetailsResult) {
                    is Result.Success -> MovieUiState.Success(followedMovieDetailsResult.data)
                    is Result.Loading -> MovieUiState.Loading
                    is Result.Error -> MovieUiState.Failed(followedMovieDetailsResult.exception)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = MovieUiState.Loading
            )

    }
}