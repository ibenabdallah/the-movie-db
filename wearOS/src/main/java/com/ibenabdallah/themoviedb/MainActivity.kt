/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.ibenabdallah.themoviedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.material3.Card
import androidx.wear.compose.material3.CardDefaults
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import androidx.wear.tooling.preview.devices.WearDevices
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.rememberAsyncImagePainter
import data.AppConfig
import data.model.NetworkMovieItem
import di.appModule
import model.MovieItem
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import ui.UIStateView
import ui.newplaying.NowPlayingViewModel
import ui.theme.TheMovieDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            WearScreen()
        }
    }
}

@Composable
fun WearScreen() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        TheMovieDBTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                WearAppContent()
            }
        }
    }
}

@Composable
fun WearAppContent() {
    val viewModel = koinInject<NowPlayingViewModel>()

    val state = remember { viewModel.getNowPlaying() }.collectAsLazyPagingItems()

    UIStateView(state.loadState.refresh) {
        ScalingLazyColumn(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            items(state.itemCount) { index ->
                val item = state[index]
                MovieItem(movie = item!!) {
                    //navigator.navigate(NavigationScreen.MovieDetail.route.plus("/${item.id}"))
                }
            }
        }
    }
}

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    movie: NetworkMovieItem, onClick: (NetworkMovieItem) -> Unit,
) {

    Card(
        onClick = {
            onClick(movie)
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(AppConfig.IMAGE_BASE_URL + movie.posterPath),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(4.dp)),
            )

            Column(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
                Text(
                    text = movie.title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2
                )

                Text(
                    text = movie.overview, fontSize = 8.sp,
                    maxLines = 1,
                    modifier = modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.W300

                )
            }
        }
    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearScreen()
}