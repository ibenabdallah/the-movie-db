package navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreen(
    val route: String,
    val title: String = "app",
    val navIcon: ImageVector = Icons.Filled.Home,
    val objectName: String = "",
    val objectPath: String = "",
) {
    data object MovieDetail :
        NavigationScreen("movie_detail_screen", objectName = "id", objectPath = "/{id}")

    data object NowPlaying : NavigationScreen("now_playing_screen", navIcon = Icons.Filled.Home)

    data object Popular : NavigationScreen("popular_screen", navIcon = Icons.Filled.Timeline)

    data object TopRated : NavigationScreen("top_rated_screen", navIcon = Icons.Filled.Star)

    data object Upcoming :
        NavigationScreen("upcoming_screen", navIcon = Icons.Filled.KeyboardArrowDown)
}