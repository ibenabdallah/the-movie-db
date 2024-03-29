package ui.newplaying


import androidx.paging.PagingData
import data.model.NetworkMovieItem
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.AllNowPlayingMovieUseCase
import kotlinx.coroutines.flow.Flow

class NowPlayingViewModel(private val useCase: AllNowPlayingMovieUseCase) : ViewModel() {

    fun getNowPlaying(): Flow<PagingData<NetworkMovieItem>> = useCase().flow

}