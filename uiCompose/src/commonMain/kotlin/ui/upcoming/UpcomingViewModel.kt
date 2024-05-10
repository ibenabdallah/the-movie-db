package ui.upcoming

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import domain.AllUpcomingMovieUseCase
import kotlinx.coroutines.flow.Flow
import model.MovieItem

class UpcomingViewModel(private val useCase: AllUpcomingMovieUseCase) : ViewModel() {

    fun getUpcoming() : Flow<PagingData<MovieItem>> = useCase()

}