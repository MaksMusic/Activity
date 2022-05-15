package com.music.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.music.activity.databinding.ActivityMainBinding
import com.music.activity.databinding.ActivityNewsBinding

class NewsActivity() : AppCompatActivity() {

    lateinit var binding: ActivityNewsBinding
    lateinit var thread1: Thread
    lateinit var gorod: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler()
        val args = intent.extras
        gorod = args?.get("GOROD").toString()

//запуск 2 потока
        var t3: T3News = T3News(gorod)
        thread1 = Thread(t3)
        thread1.start()

//присвоения View элементам значения

        Handler().postDelayed({
            binding.textRubDollar.setText(t3.rubDollar())
            binding.textRubEuro.setText(t3.rubEuro())
            binding.textRubLir.setText(t3.rubLIR())
            binding.textRubYuan.setText(t3.rubUAN())

        }, 2000)


    }
}