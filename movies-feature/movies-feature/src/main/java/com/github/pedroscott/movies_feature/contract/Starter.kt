package com.github.pedroscott.movies_feature.contract

import com.github.pedroscott.movies_feature.feature.LibMainActivity

interface Starter {

    fun start(destination: Class<LibMainActivity> = LibMainActivity::class.java)
}