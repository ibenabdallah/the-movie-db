package domain.di

import domain.AllNowPlayingMovieUseCase
import domain.AllNowPlayingMovieUseCaseImpl
import domain.AllPopularMovieUseCase
import domain.AllPopularMovieUseCaseImpl
import domain.AllTopRatedMovieUseCase
import domain.AllTopRatedMovieUseCaseImpl
import domain.AllUpcomingMovieUseCase
import domain.AllUpcomingMovieUseCaseImpl
import domain.MovieDetailsUseCase
import domain.MovieDetailsUseCaseImpl
import domain.mapper.MovieDetailsMapper
import domain.mapper.MovieDetailsMapperImpl
import domain.mapper.MovieMapper
import domain.mapper.MovieMapperImpl
import org.koin.dsl.module

val domainModule = module {

    single<MovieMapper> { MovieMapperImpl() }

    single<MovieDetailsMapper> { MovieDetailsMapperImpl() }

    single<AllNowPlayingMovieUseCase> { AllNowPlayingMovieUseCaseImpl(get(), get()) }

    single<AllTopRatedMovieUseCase> { AllTopRatedMovieUseCaseImpl(get(), get()) }

    single<AllPopularMovieUseCase> { AllPopularMovieUseCaseImpl(get(), get()) }

    single<AllUpcomingMovieUseCase> { AllUpcomingMovieUseCaseImpl(get(), get()) }

    single<MovieDetailsUseCase> { MovieDetailsUseCaseImpl(get(), get()) }
}