package com.music.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.music.activity.databinding.ActivityCtityBinding

class CityActivity : AppCompatActivity() {
    lateinit var binding: ActivityCtityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityCtityBinding.inflate(layoutInflater)



    }
}