package com.github.pedroscott.movies_feature.extension

fun Double.getViewsFormat() : String = "${this.toInt()} Views"

fun Double.getStarsFormat() : String = "$this Stars"