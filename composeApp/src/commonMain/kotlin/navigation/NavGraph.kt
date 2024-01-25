package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import ui.details.DetailsScreen
import ui.newplaying.NowPlayingScreen
import ui.popular.PopularScreen
import ui.toprated.TopRatedScreen
import ui.upcoming.UpcomingScreen

@Composable
fun Navigation(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = NavigationScreen.NowPlaying.route,
    ) {
        scene(route = NavigationScreen.NowPlaying.route) {
            NowPlayingScreen(navigator)
        }
        scene(route = NavigationScreen.Popular.route) {
            PopularScreen(navigator)
        }
        scene(route = NavigationScreen.TopRated.route) {
            TopRatedScreen(navigator)
        }
        scene(route = NavigationScreen.Upcoming.route) {
            UpcomingScreen(navigator)
        }
        scene(route = NavigationScreen.MovieDetail.route.plus(NavigationScreen.MovieDetail.objectPath)) { backStackEntry ->
            backStackEntry.path<Int>(NavigationScreen.MovieDetail.objectName)?.let { movieId ->
                DetailsScreen(movieId)
            }
        }
    }
}

@Composable
fun currentRoute(navigator: Navigator): String? {
    return navigator.currentEntry.collectAsState(null).value?.route?.route
}