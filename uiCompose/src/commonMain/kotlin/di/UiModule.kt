package di

import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ui.details.MovieDetailViewModel
import ui.newplaying.NowPlayingViewModel
import ui.popular.PopularViewModel
import ui.toprated.TopRatedViewModel
import ui.upcoming.UpcomingViewModel

val uiModule = module {

    viewModel { NowPlayingViewModel(get()) }

    viewModel { TopRatedViewModel(get()) }

    viewModel { PopularViewModel(get()) }

    viewModel { UpcomingViewModel(get()) }

    viewModel { MovieDetailViewModel(get()) }

}