package com.music.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.music.activity.databinding.ActivityCtityBinding
import com.music.activity.databinding.ActivitySunriseBinding
import com.music.activity.utilSharePreferenes.Constants
import com.music.activity.utilSharePreferenes.PreferencesManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class SunriseActivity : AppCompatActivity() {
    var infoJsoup: Document? = null;
    var city:String = "non"
     var n2: Elements? = null
    lateinit var preferencesManager: PreferencesManager
    lateinit var binding: ActivitySunriseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunriseBinding.inflate(layoutInflater)

        preferencesManager = PreferencesManager(this)
        setContentView(binding.root)
        jsoupCitySetting()
        updateInfo()
        exit()


}

fun jsoupCitySetting(){
    if (preferencesManager.getStringCity(Constants.KEY_SITIES)!=null){
        when(preferencesManager.getStringCity(Constants.KEY_SITIES).toString()){
            "Ростов-на-Дону" -> city = "rostov-na-donu-5110"
            "Дербент" -> city = "derbent-5268"
            "Санкт-Петербург" -> city = "sankt-peterburg-4079"
            "Белиджи" -> city = "belidzhi-12497"
            "Псков" -> city = "pskov-4114"

        }
    }
}


    fun updateInfo(){
        lifecycleScope.launch(Dispatchers.IO){
            if (city!="non" && n2!=null) {
                infoJsoup = Jsoup.connect("https://www.gismeteo.ru/weather-$city/now/")
                    .data("class", "time").get()
                n2 = infoJsoup?.getElementsByAttributeValue("class", "time")
            }
            withContext(Dispatchers.Main){
                if (n2 != null){
                    if (preferencesManager.getStringCity(Constants.KEY_SITIES)!=null){
                        binding.textCity.setText(preferencesManager.getStringCity(Constants.KEY_SITIES).toString())
                    }
                    binding.textSunriseTime.setText( n2!![1].text().toString())
                    binding.textSunsetTime.setText( n2!![0].text().toString())
                }

            }
        }
    }

    fun exit() {
        binding.exit.setOnClickListener() {
            finish()
        }
    }
}