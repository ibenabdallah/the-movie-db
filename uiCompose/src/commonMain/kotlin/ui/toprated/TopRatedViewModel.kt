package ui.toprated


import androidx.paging.PagingData
import data.model.NetworkMovieItem
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.AllTopRatedMovieUseCase
import kotlinx.coroutines.flow.Flow

class TopRatedViewModel(private val useCase : AllTopRatedMovieUseCase) : ViewModel() {

    fun getTopRated() : Flow<PagingData<NetworkMovieItem>> = useCase().flow
}