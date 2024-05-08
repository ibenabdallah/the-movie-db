package ui.toprated


import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import domain.AllTopRatedMovieUseCase
import kotlinx.coroutines.flow.Flow
import model.MovieItem

class TopRatedViewModel(private val useCase : AllTopRatedMovieUseCase) : ViewModel() {

    fun getTopRated() : Flow<PagingData<MovieItem>> = useCase()
}