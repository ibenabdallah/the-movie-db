import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import di.appModule
import navigation.Navigation
import navigation.NavigationScreen
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.KoinApplication
import themoviedb.uicompose.generated.resources.Res
import themoviedb.uicompose.generated.resources.*
import ui.theme.TheMovieDBTheme
import ui.utils.AppBarWithArrow
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AppScreen() {

    val navController: NavHostController = rememberNavController()

    KoinApplication(application = {
        modules(appModule)
    }) {
        TheMovieDBTheme {
            Scaffold(
                bottomBar = {
                    BottomNavigation(navController)
                },
                topBar = {
                    AppBarWithArrow(
                        title = stringResource(Res.string.app_name),
                        isBackEnable = isBottomNavigation(navController).not()
                    ) {
                        navController.navigateUp()
                    }
                }

            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues = paddingValues)) {
                    Navigation(navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(navController: NavHostController) {

    if (isBottomNavigation(navController)) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        NavigationBar {
            listOf(
                NavigationScreen.NowPlaying,
                NavigationScreen.TopRated,
                NavigationScreen.Popular,
                NavigationScreen.Upcoming
            ).forEach { screen ->
                val title = stringResource(screen.resourceId)
                NavigationBarItem(
                    label = { Text(text = title, maxLines = 1) },
                    selected = currentDestination?.hierarchy?.any { it.route == screen.name } == true,
                    icon = {
                        Icon(imageVector = screen.navIcon, contentDescription = title)
                    },
                    onClick = {
                        navController.navigate(screen.name) { launchSingleTop = true }
                    }
                )
            }
        }
    }
}
@Composable
fun isBottomNavigation(navController: NavHostController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    return when (currentDestination?.route) {
        NavigationScreen.NowPlaying.name,
        NavigationScreen.Popular.name,
        NavigationScreen.TopRated.name,
        NavigationScreen.Upcoming.name,
        -> true

        else -> false
    }
}

