package com.github.pedroscott.movies_feature.utils

sealed class Command {
    class Loading(val value: Boolean): Command()
    class Error(val error: Int): Command()
}
