package data.remote

import getPlatform
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.encodedPath

fun HttpRequestBuilder.uRLBuilderMovie(path: String, page: Int) {
    url {
        encodedPath = path
        parameters.append("language", getPlatform().local.lang())
        parameters.append("page", page.toString())
    }
}

fun HttpRequestBuilder.movieDetail(movieId: Int) {
    url {
        encodedPath = "movie/$movieId"
        parameters.append("language", getPlatform().local.lang())
    }
}