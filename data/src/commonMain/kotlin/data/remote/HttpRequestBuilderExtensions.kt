package data.remote

import getLocale
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.URLBuilder
import io.ktor.http.encodedPath

internal fun HttpRequestBuilder.uRLBuilderMovie(path: String, page: Int) {
    url {
        encodedPath = path
        parameters.append("page", page.toString())
        appendLanguage()
    }
}

internal fun HttpRequestBuilder.movieDetail(movieId: Int) {
    url {
        encodedPath = "movie/$movieId"
        appendLanguage()
    }
}

private fun URLBuilder.appendLanguage(){
    parameters.append("language", getLocale().lang())
}