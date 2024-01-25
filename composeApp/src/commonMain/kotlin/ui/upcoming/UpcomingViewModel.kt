package ui.upcoming

import androidx.paging.PagingData
import data.model.MovieItem
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.AllUpcomingMovieUseCase
import kotlinx.coroutines.flow.Flow

class UpcomingViewModel(private val useCase: AllUpcomingMovieUseCase) : ViewModel() {

    fun getUpcoming() : Flow<PagingData<MovieItem>> = useCase().flow

}