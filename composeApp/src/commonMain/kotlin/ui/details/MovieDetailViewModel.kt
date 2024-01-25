package ui.details

import data.DataState
import data.model.details.MovieDetails
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.DetailsMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MovieDetailViewModel (private val useCase : DetailsMovieUseCase): ViewModel() {

    val movieDetail = MutableStateFlow<DataState<MovieDetails>>(DataState.Loading)

    fun movieDetail(movieId: Int) {
        viewModelScope.launch {
            useCase.invoke(movieId).collectLatest {
                movieDetail.value = it
            }
        }
    }
}