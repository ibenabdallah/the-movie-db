package ui.toprated

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import moe.tlaster.precompose.navigation.Navigator
import navigation.NavigationScreen
import org.koin.compose.koinInject
import ui.MovieItem
import ui.UIStateView


@Composable
fun TopRatedScreen(navigator: Navigator) {

    val viewModel = koinInject<TopRatedViewModel>()

    val state = remember { viewModel.getTopRated() }.collectAsLazyPagingItems()

    UIStateView(state.loadState.refresh) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = rememberLazyGridState(),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
        ) {
            items(state.itemCount) { index ->
                val item = state[index]
                MovieItem(movie = item!!) { movie ->
                    navigator.navigate(NavigationScreen.MovieDetail.route.plus("/${movie.id}"))
                }
            }
        }
    }
}