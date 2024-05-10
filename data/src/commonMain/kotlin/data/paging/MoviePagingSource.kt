package data.paging


import app.cash.paging.PagingSource
import app.cash.paging.PagingSourceLoadParams
import app.cash.paging.PagingSourceLoadResult
import app.cash.paging.PagingSourceLoadResultError
import app.cash.paging.PagingSourceLoadResultPage
import app.cash.paging.PagingState
import data.ResponseError
import data.model.MoviesEntity
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import kotlinx.serialization.json.Json

internal class MoviePagingSource<T : Any>(
    private val fetch: suspend (page: Int) -> MoviesEntity<T>,
) : PagingSource<Int, T>() {

    private var currentPage: Int = 0
    private var hasNext: Boolean = false

    override fun getRefreshKey(state: PagingState<Int, T>): Int = currentPage

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, T> {

        return try {
            val previousKey = currentPage
            val response = fetch(getPage(params))
            currentPage = response.page
            hasNext = response.page < response.totalPages
            PagingSourceLoadResultPage(
                data = response.results,
                prevKey = previousKey,
                nextKey = getKey(),
            )
        } catch (e: ClientRequestException) {
            val errorString = e.response.body<String>()
            val responseError = Json.decodeFromString<ResponseError>(errorString)
            PagingSourceLoadResultError(responseError)
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