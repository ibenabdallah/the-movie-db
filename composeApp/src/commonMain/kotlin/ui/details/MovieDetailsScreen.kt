package ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import org.koin.compose.koinInject
import ui.UIStateView


@Composable
fun DetailsScreen(movieId: Int) {

    val detailsViewModel = koinInject<MovieDetailViewModel>()

    LaunchedEffect(1) {
        detailsViewModel.movieDetail(movieId)
    }
    val state = detailsViewModel.movieDetail.collectAsState().value

    UIStateView(state) {
        UIMovieDetails(it)
    }

}