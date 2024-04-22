package ui

import data.ResponseError
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.serialization.json.Json

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: Throwable) : Result<Nothing>
    data object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> = map<T, Result<T>> { Result.Success(it) }
    .onStart { emit(Result.Loading) }
    .catch {
        when (it) {
            is ClientRequestException -> {
                val errorString = it.response.body<String>()
                val responseError = Json.decodeFromString<ResponseError>(errorString)
                emit(Result.Error(responseError))
            }

            else -> emit(Result.Error(it))
        }
    }