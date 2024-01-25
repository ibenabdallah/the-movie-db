package ui.di

import di.viewModelDefinition
import org.koin.dsl.module
import ui.details.MovieDetailViewModel
import ui.newplaying.NowPlayingViewModel
import ui.popular.PopularViewModel
import ui.toprated.TopRatedViewModel
import ui.upcoming.UpcomingViewModel

val uiModule = module {

    viewModelDefinition { NowPlayingViewModel(get()) }

    viewModelDefinition { TopRatedViewModel(get()) }

    viewModelDefinition { PopularViewModel(get()) }

    viewModelDefinition { UpcomingViewModel(get()) }

    viewModelDefinition { MovieDetailViewModel(get()) }

}