package com.github.pedroscott.movies_feature.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.pedroscott.movies_feature.databinding.ActivityMainLibBinding

class LibMainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainLibBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}