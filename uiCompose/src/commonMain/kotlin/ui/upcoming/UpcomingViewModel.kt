package ui.upcoming

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import data.model.NetworkMovieItem
import domain.AllUpcomingMovieUseCase
import kotlinx.coroutines.flow.Flow

class UpcomingViewModel(private val useCase: AllUpcomingMovieUseCase) : ViewModel() {

    fun getUpcoming() : Flow<PagingData<NetworkMovieItem>> = useCase().flow

}