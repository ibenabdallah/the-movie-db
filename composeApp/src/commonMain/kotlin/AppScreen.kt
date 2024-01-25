import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ibenabdallah.themoviedb.MR
import dev.icerock.moko.resources.compose.stringResource
import di.appModule
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import navigation.Navigation
import navigation.NavigationScreen
import navigation.currentRoute
import org.koin.compose.KoinApplication
import ui.theme.TheMovieDBTheme
import ui.utils.AppBarWithArrow


@Composable
fun AppScreen() {
    PreComposeApp {
        KoinApplication(application = {
            modules(appModule)
        }) {

            val navigator = rememberNavigator()

            TheMovieDBTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation(navigator)
                    },
                    topBar = {
                        AppBarWithArrow(
                            title = stringResource(MR.strings.app_name),
                            isBackEnable = isBottomNavigation(navigator).not()
                        ) {
                            navigator.goBack()
                        }
                    }

                ) { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues = paddingValues)) {
                        Navigation(navigator)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(navigator: Navigator) {
    if (isBottomNavigation(navigator)) {
        NavigationBar {
            listOf(
                NavigationScreen.NowPlaying,
                NavigationScreen.TopRated,
                NavigationScreen.Popular,
                NavigationScreen.Upcoming,
            ).forEach {
                NavigationBarItem(
                    label = { Text(text = getTitle(it), maxLines = 1) },
                    selected = it.route == currentRoute(navigator),
                    icon = {
                        Icon(imageVector = it.navIcon, contentDescription = it.title)
                    },
                    onClick = {
                        navigator.navigate(it.route, NavOptions(launchSingleTop = true))
                    }
                )
            }
        }
    }
}

@Composable
fun getTitle(screen: NavigationScreen): String {
    return when (screen) {
        NavigationScreen.NowPlaying -> stringResource(MR.strings.now_playing)
        NavigationScreen.Popular -> stringResource(MR.strings.popular)
        NavigationScreen.TopRated -> stringResource(MR.strings.top_rated)
        NavigationScreen.Upcoming -> stringResource(MR.strings.upcoming)
        else -> ""
    }
}

@Composable
fun isBottomNavigation(navigator: Navigator): Boolean = when (currentRoute(navigator)) {
    NavigationScreen.NowPlaying.route,
    NavigationScreen.Popular.route,
    NavigationScreen.TopRated.route,
    NavigationScreen.Upcoming.route,
    -> true

    else -> false
}

