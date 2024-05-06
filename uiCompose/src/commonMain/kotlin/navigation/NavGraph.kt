package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ui.details.DetailsScreen
import ui.newplaying.NowPlayingScreen
import ui.popular.PopularScreen
import ui.toprated.TopRatedScreen
import ui.upcoming.UpcomingScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.NowPlaying.name,
    ) {
        composable(route = NavigationScreen.NowPlaying.name) {
            NowPlayingScreen(navController)
        }
        composable(route = NavigationScreen.Popular.name) {
            PopularScreen(navController)
        }
        composable(route = NavigationScreen.TopRated.name) {
            TopRatedScreen(navController)
        }
        composable(route = NavigationScreen.Upcoming.name) {
            UpcomingScreen(navController)
        }
        composable(
            route = NavigationScreen.MovieDetail.name.plus(NavigationScreen.MovieDetail.objectPath),
            arguments = listOf(navArgument(NavigationScreen.MovieDetail.objectName) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt(NavigationScreen.MovieDetail.objectName)
                ?.let { movieId ->
                    DetailsScreen(movieId)
                }
        }
    }
}