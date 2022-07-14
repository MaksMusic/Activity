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
    var city: String = "non"
    var sunriseJsoup: Elements? = null
    var dataJsoup: Elements? = null
    var INTERNET_ON = false
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

    fun jsoupCitySetting() {
        if (preferencesManager.getStringCity(Constants.KEY_SITIES) != null) {
            when (preferencesManager.getStringCity(Constants.KEY_SITIES).toString()) {
                "Ростов-на-Дону" -> city = "rostov-na-donu-5110"
                "Дербент" -> city = "derbent-5268"
                "Санкт-Петербург" -> city = "sankt-peterburg-4079"
                "Белиджи" -> city = "belidzhi-12497"
                "Псков" -> city = "pskov-4114"
            }
        }
    }


    fun updateInfo() {
        lifecycleScope.launch(Dispatchers.IO) {
            if (city != "non") {
                try {


                    infoJsoup = Jsoup.connect("https://www.gismeteo.ru/weather-$city/now/")
                        ?.data("class", "time")?.get()

                    if (infoJsoup != null) {
                        INTERNET_ON = true
                        sunriseJsoup = infoJsoup?.getElementsByAttributeValue("class", "time")
                        dataJsoup = infoJsoup?.getElementsByAttributeValue("class", "now-localdate")
                    } else {
                        INTERNET_ON = false
                    }



                    withContext(Dispatchers.Main) {
                        if (INTERNET_ON == true) {
                            if (sunriseJsoup != null && dataJsoup != null) {
                                binding.textCity.setText(
                                    preferencesManager.getStringCity(Constants.KEY_SITIES)
                                        .toString()
                                )
                                binding.textData.setText(dataJsoup!!.text().toString())
                                binding.textSunriseTime.setText(sunriseJsoup!![1].text().toString())
                                binding.textSunsetTime.setText(sunriseJsoup!![0].text().toString())
                            }

                        } else {
                            binding.textCity.setText(
                                preferencesManager.getStringCity(Constants.KEY_SITIES).toString()
                            )
                            textEdit("нет соединения")
                        }
                    }
                }catch (e:Exception){
                    textEdit("выберите город в главном меню")
                }
            } else {
                withContext(Dispatchers.Main) {
                    textEdit("выберите город в главном меню")
                }
            }

        }

    }


    fun textEdit(textDataEdit: String) {
        binding.textData.setText(textDataEdit)
        binding.textSunriseTime.setText("")
        binding.textSunsetTime.setText("")
    }

    fun exit() {
        binding.exit.setOnClickListener() {
            finish()
        }
    }
}