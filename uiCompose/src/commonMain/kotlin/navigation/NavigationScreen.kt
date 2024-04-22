package navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource
import themoviedb.uicompose.generated.resources.Res
import themoviedb.uicompose.generated.resources.*

@OptIn(ExperimentalResourceApi::class)
enum class NavigationScreen(
    val navIcon: ImageVector = Icons.Filled.Home,
    val resourceId: StringResource = Res.string.app_name,
    val objectName: String = "",
    val objectPath: String = "",
) {
    MovieDetail(objectName = "movieId", objectPath = "/{movieId}"),

    NowPlaying(resourceId = Res.string.now_playing, navIcon = Icons.Filled.Home),

    Popular(resourceId = Res.string.popular, navIcon = Icons.Filled.Timeline),

    TopRated(resourceId = Res.string.top_rated, navIcon = Icons.Filled.Star),

    Upcoming(resourceId = Res.string.upcoming, navIcon = Icons.Filled.KeyboardArrowDown),
}