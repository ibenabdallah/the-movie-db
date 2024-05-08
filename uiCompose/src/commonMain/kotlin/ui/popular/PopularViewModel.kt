package ui.popular


import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import domain.AllPopularMovieUseCase
import kotlinx.coroutines.flow.Flow
import model.MovieItem

class PopularViewModel(private val useCase : AllPopularMovieUseCase) : ViewModel() {

    fun getPopular() : Flow<PagingData<MovieItem>> = useCase()

}