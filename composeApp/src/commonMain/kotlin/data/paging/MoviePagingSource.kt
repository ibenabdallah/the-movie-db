package data.paging


import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import data.Status
import data.model.PaginatedMovie

class MoviePagingSource<T : Any>(
    private val fetch: suspend (page: Int) -> Status<PaginatedMovie<T>>,
) : PagingSource<Int, T>() {

    private var currentPage: Int = 0
    private var hasNext: Boolean = false

    override fun getRefreshKey(state: PagingState<Int, T>): Int  = currentPage

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, T> {

        return try {
            val previousKey = currentPage
            when (val response = fetch(getPage(params))) {
                is Status.Success -> {
                    currentPage = response.data.page
                    hasNext = response.data.page < response.data.totalPages
                    PagingSourceLoadResultPage(
                        data = response.data.results,
                        prevKey = previousKey,
                        nextKey = getKey(),
                    )
                }

                is Status.Error -> PagingSourceLoadResultError(response.error)
            }
        } catch (e: Exception) {
            PagingSourceLoadResultError(e)
        }
    }

    private fun getPage(params: PagingSourceLoadParams<Int>) = params.key ?: FIRST_PAGE_INDEX

    private fun getKey(): Int? = if (hasNext) currentPage + 1 else null

    companion object {
        const val FIRST_PAGE_INDEX = 1
    }
}