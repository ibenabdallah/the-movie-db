package ui.popular


import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import data.model.NetworkMovieItem
import domain.AllPopularMovieUseCase
import kotlinx.coroutines.flow.Flow

class PopularViewModel(private val useCase : AllPopularMovieUseCase) : ViewModel() {

    fun getPopular() : Flow<PagingData<NetworkMovieItem>> = useCase().flow

}