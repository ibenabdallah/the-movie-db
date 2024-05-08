package ui.newplaying


import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import domain.AllNowPlayingMovieUseCase
import kotlinx.coroutines.flow.Flow
import model.MovieItem

class NowPlayingViewModel(private val useCase: AllNowPlayingMovieUseCase) : ViewModel() {

    fun getNowPlaying(): Flow<PagingData<MovieItem>> = useCase()

}