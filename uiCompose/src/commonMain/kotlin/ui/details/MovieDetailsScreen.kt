package ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import model.MovieDetails
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import ui.UiState
import ui.UIStateView


@OptIn(KoinExperimentalAPI::class)
@Composable
fun DetailsScreen(movieId: Int) {

    val detailsViewModel = koinViewModel<MovieDetailViewModel>()

    val state: State<UiState<out MovieDetails>> = detailsViewModel.movieDetail(movieId).collectAsState()

    UIStateView(state) {
        UIMovieDetails(it)
    }

}