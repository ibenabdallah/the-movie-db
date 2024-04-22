package ui.toprated


import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import data.model.NetworkMovieItem
import domain.AllTopRatedMovieUseCase
import kotlinx.coroutines.flow.Flow

class TopRatedViewModel(private val useCase : AllTopRatedMovieUseCase) : ViewModel() {

    fun getTopRated() : Flow<PagingData<NetworkMovieItem>> = useCase().flow
}