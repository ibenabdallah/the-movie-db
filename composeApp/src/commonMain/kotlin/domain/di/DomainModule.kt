package domain.di

import domain.AllNowPlayingMovieUseCase
import domain.AllNowPlayingMovieUseCaseImpl
import domain.AllPopularMovieUseCase
import domain.AllPopularMovieUseCaseImpl
import domain.AllTopRatedMovieUseCase
import domain.AllTopRatedMovieUseCaseImpl
import domain.AllUpcomingMovieUseCase
import domain.AllUpcomingMovieUseCaseImpl
import domain.DetailsMovieUseCase
import domain.DetailsMovieUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<AllNowPlayingMovieUseCase> { AllNowPlayingMovieUseCaseImpl(get()) }

    single<AllTopRatedMovieUseCase> { AllTopRatedMovieUseCaseImpl(get()) }

    single<AllPopularMovieUseCase> { AllPopularMovieUseCaseImpl(get()) }

    single<AllUpcomingMovieUseCase> { AllUpcomingMovieUseCaseImpl(get()) }

    single<DetailsMovieUseCase> { DetailsMovieUseCaseImpl(get()) }
}