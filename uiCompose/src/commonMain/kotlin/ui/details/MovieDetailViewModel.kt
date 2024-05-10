package ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.MovieDetailsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import model.MovieDetails
import result.DomainResult
import ui.UiState

class MovieDetailViewModel(private val useCase: MovieDetailsUseCase) : ViewModel() {

    fun movieDetail(movieId: Int): StateFlow<UiState<out MovieDetails>> {

        return useCase.invoke(movieId).distinctUntilChanged()
            .map { followedMovieDetailsResult ->
                when (followedMovieDetailsResult) {
                    is DomainResult.Success -> UiState.Success(followedMovieDetailsResult.data)
                    is DomainResult.Failure -> UiState.Failure(followedMovieDetailsResult.exception)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading
            )

    }
}