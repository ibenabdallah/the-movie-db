package ui.newplaying

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import app.cash.paging.compose.collectAsLazyPagingItems
import navigation.NavigationScreen
import org.koin.compose.viewmodel.koinViewModel
import ui.MovieItem
import ui.UIStateView


@Composable
fun NowPlayingScreen(navController: NavHostController) {

    val viewModel = koinViewModel<NowPlayingViewModel>()

    val state = remember { viewModel.getNowPlaying() }.collectAsLazyPagingItems()

    UIStateView(state.loadState.refresh) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = rememberLazyGridState(),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
        ) {
            items(state.itemCount) { index ->
                val item = state[index]
                MovieItem(movie = item!!) {
                    navController.navigate(NavigationScreen.MovieDetail.name.plus("/${item.id}"))
                }
            }
        }
    }
}