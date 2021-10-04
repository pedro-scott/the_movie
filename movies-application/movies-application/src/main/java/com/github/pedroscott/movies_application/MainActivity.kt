package com.github.pedroscott.movies_application

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.pedroscott.movies_application.databinding.ActivityMainBinding
import com.github.pedroscott.movies_feature.contract.Starter
import com.github.pedroscott.movies_feature.feature.LibMainActivity

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val starter: Starter by lazy {
        object : Starter {
            override fun start(destination: Class<LibMainActivity>) {
                startActivity(Intent(this@MainActivity, destination))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            starter.start()
        }
    }
}