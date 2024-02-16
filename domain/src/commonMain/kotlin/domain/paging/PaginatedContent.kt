package domain.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow

interface PaginatedContent<T : Any> {
    val pager: Pager<Int, T>
    val flow: Flow<PagingData<T>> get() = pager.flow

    var pagingSource: PagingSource<Int, T>?

    fun invalidate() {
        pagingSource?.invalidate()
    }
}

class PaginatedContentImpl<T : Any>(
    config: PagingConfig = PagingConfig(pageSize = 20, initialLoadSize = 20),
    val fetch: () -> PagingSource<Int, T>,
) : PaginatedContent<T> {

    override var pagingSource: PagingSource<Int, T>? = null

    override val pager =
        Pager(
            config = config,
            pagingSourceFactory = {
                fetch()
                    .also {
                        pagingSource = it
                    }
            }
        )
}