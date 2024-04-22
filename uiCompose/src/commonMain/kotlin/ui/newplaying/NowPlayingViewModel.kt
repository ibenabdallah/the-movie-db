package ui.newplaying


import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import data.model.NetworkMovieItem
import domain.AllNowPlayingMovieUseCase
import kotlinx.coroutines.flow.Flow

class NowPlayingViewModel(private val useCase: AllNowPlayingMovieUseCase) : ViewModel() {

    fun getNowPlaying(): Flow<PagingData<NetworkMovieItem>> = useCase().flow

}