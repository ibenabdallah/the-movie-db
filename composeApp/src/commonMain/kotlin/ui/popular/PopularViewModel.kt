package ui.popular


import androidx.paging.PagingData
import data.model.MovieItem
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.AllPopularMovieUseCase
import kotlinx.coroutines.flow.Flow

class PopularViewModel(private val useCase : AllPopularMovieUseCase) : ViewModel() {

    fun getPopular() : Flow<PagingData<MovieItem>> = useCase().flow

}