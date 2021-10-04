package com.github.pedroscott.movies_feature.extension

import com.github.pedroscott.movies_feature.utils.Constants.TmdbApi.BASE_URL_IMAGE

fun String.getFullImageUrl(width: Int): String = "${BASE_URL_IMAGE}w${width}${this}"

fun String.getYear() = this.take(4)

fun String.getDateBrFormat(): String {
    var date = ""

    this.split("-").asReversed().forEachIndexed { i, string ->
        date += string

        if (i < 2)
            date += "/"
    }

    return date
}