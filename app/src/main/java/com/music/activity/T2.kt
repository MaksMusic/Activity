package com.music.activity

import android.content.Context
import android.net.*
import android.os.AsyncTask
import android.os.Build
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.music.activity.databinding.ActivityMainBinding
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.lang.Exception
import android.widget.Toast.makeText as makeText1
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.getSystemService
import java.util.*
import kotlin.collections.ArrayList


val day = Array<String>(40) { "" };
val day2 = Array<String>(40) { "" };

class T2(var City: String) : Runnable {

    lateinit var weatherDay1:ArrayList<String>
    lateinit var weatherDay2:ArrayList<String>
    var htmlDay1: Document? = null // страница дня 1
    var htmlDay2: Document? = null // страница дня 1
    var doc: Document? = null
    var docDay2: Document? = null;
    var doc2: Document? = null;
    var docTime: Document? = null;
    var n3: Element? = null;
    var n4: Element? = null;
    var n5: Element? = null;
    var n2: Elements? = null;
    var n2Day2: Elements? = null;
    var nameCity: Elements? = null;
    private var time: Int = 0;


    init {
        weatherDay1 = ArrayList<String>()
        weatherDay2 = ArrayList<String>()

    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun run() {
        Log.e("CITY:", City.toString())
        var docCityHttp = mutableMapOf<String, List<String>>()





        docCityHttp.put(
            "Ростов-на-Дону", listOf(
                "https://www.gismeteo.ru/weather-rostov-na-donu-5110/",
                "https://www.gismeteo.ru/weather-rostov-na-donu-5110/now",
                "class",
                "input js-input",
                "https://www.gismeteo.ru/weather-rostov-na-donu-5110/tomorrow/",
            )
        )

        docCityHttp.put(
            "Санкт-Петербург", listOf(
                "https://www.gismeteo.ru/weather-sankt-peterburg-4079/",
                "https://www.gismeteo.ru/weather-sankt-peterburg-4079/now/",
                "class",
                "input js-input",
                "https://www.gismeteo.ru/weather-sankt-peterburg-4079/tomorrow/",
            )
        )


        docCityHttp.put(
            "Дербент", listOf(
                "https://www.gismeteo.ru/weather-derbent-5268/",
                "https://www.gismeteo.ru/weather-derbent-5268/now/",
                "class",
                "input js-input",
                "https://www.gismeteo.ru/weather-derbent-5268/tomorrow/"
            )
        )

        docCityHttp.put(
            "Белиджи", listOf(
                "https://www.gismeteo.ru/weather-belidzhi-12497/",
                "https://www.gismeteo.ru/weather-belidzhi-12497/now/",
                "class",
                "input js-input",
                "https://www.gismeteo.ru/weather-belidzhi-12497/tomorrow/"
            )
        )


        docCityHttp.put(
            "Псков", listOf(
                "https://www.gismeteo.ru/weather-pskov-4114/",
                "https://www.gismeteo.ru/weather-pskov-4114/now/",
                "class",
                "input js-input",
                "https://www.gismeteo.ru/weather-pskov-4114/tomorrow/"
            )
        )


        var l: Boolean = false;

        try {

            for ((key, value) in docCityHttp) {
                if (key.equals(City.trim())) {
                    Log.e("CITYT:", key.toString())

                    l = true;
                    // день 1 градусы


                    doc = Jsoup.connect(docCityHttp.get(key)?.get(0))
                        .data(docCityHttp.get(key)?.get(2), docCityHttp.get(key)?.get(3))
                        .get()

                    doc2 = Jsoup.connect(docCityHttp.get(key)?.get(1))
                        .data(docCityHttp.get(key)?.get(2), docCityHttp.get(key)?.get(3))
                        .get()

                    htmlDay1 = Jsoup.connect(docCityHttp.get(key)?.get(0)).get()
                    htmlDay2 = Jsoup.connect(docCityHttp.get(key)?.get(4)).get()
                    //weter  = html.select("div[class=weather-icon tooltip]")[0].attr("data-text")


                    docTime = Jsoup.connect(docCityHttp.get(key)?.get(1))
                        .data(docCityHttp.get(key)?.get(2), "day")
                        .get()
                    // день 2 градусы
                    docDay2 = Jsoup.connect(docCityHttp.get(key)?.get(4))
                        .data(docCityHttp.get(key)?.get(2), "unit unit_temperature_c")
                        .get()

                    break

                } else {
                    Log.e("CITYT:", key.toString() + "elseeeeeeeeeeeeeee")
                    l = false
                }

            }

            if (l == false) {
                doc = Jsoup.connect(docCityHttp.get("Ростов-на-Дону")?.get(0)).data(
                    docCityHttp.get("Ростов-на-Дону")?.get(2),
                    docCityHttp.get("Ростов-на-Дону")?.get(3)
                ).get()

                doc2 = Jsoup.connect(docCityHttp.get("Ростов-на-Дону")?.get(1))
                    .data(
                        docCityHttp.get("Ростов-на-Дону")?.get(2),
                        docCityHttp.get("Ростов-на-Дону")?.get(3)
                    )
                    .get()

                docTime = Jsoup.connect(docCityHttp.get("Ростов-на-Дону")?.get(1))
                    .data(docCityHttp.get("Ростов-на-Дону")?.get(2), "day")
                    .get()

                // день 2 градусы
                docDay2 = Jsoup.connect(docCityHttp.get("Ростов-на-Дону")?.get(4))
                    .data(docCityHttp.get("Ростов-на-Дону")?.get(2), "unit unit_temperature_c")
                    .get()
            }


        } catch (e: Exception) {
        }

        try {

            n2 = doc!!.getElementsByAttributeValue(
                "class",
                "unit unit_temperature_c"
            ) // список грудусов сегодня
            n2Day2 = docDay2!!.getElementsByAttributeValue(
                "class",
                "unit unit_temperature_c"
            ) // список грудусов сегодня
            n3 = doc2!!.getElementsByAttributeValue("class", "now-desc").get(0) // текс погоды
            n4 = doc2!!.getElementsByAttributeValue("class", "unit unit_wind_m_s").get(0) //ветер
            n5 = doc2!!.getElementsByAttributeValue("class", "day").get(0) //время
            nameCity = doc!!.getElementsByAttributeValue("class", "page-title")

            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[0].attr("data-text").toString()
                    .substringBefore(',').trim()) //
            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[5].attr("data-text").toString()
                    .substringAfterLast(',').trim()) //

            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[2].attr("data-text").toString()
                    .substringBefore(',').trim()) //

            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[3].attr("data-text").toString()
                    .substringBefore(',').trim()) //

            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[4].attr("data-text").toString()
                    .substringBefore(',').trim()) //

            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[6].attr("data-text").toString()
                    .substringBefore(',').trim()) //


            weatherDay1.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[7].attr("data-text").toString()
                    .substringAfter(',').trim()) //

            // day2
            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[0].attr("data-text").toString()
                    .substringAfter(',').trim()) //
            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[5].attr("data-text").toString()
                    .substringAfter(',').trim()) //

            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[2].attr("data-text").toString()
                    .substringAfter(',').trim()) //

            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[3].attr("data-text").toString()
                    .substringAfter(',').trim()) //

            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[4].attr("data-text").toString()
                    .substringAfter(',').trim()) //

            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[6].attr("data-text").toString()
                    .substringAfter(',').trim()) //


            weatherDay2.add(
                htmlDay1!!.select("div[class=weather-icon tooltip]")[7].attr("data-text").toString()
                    .substringAfter(',').trim()) //


        } catch (e: Exception) {

        }




        if (n2 != null || n3 != null || n4 != null || n5 != null || weatherDay1.isEmpty()) {

            day[0] = n2?.get(0)?.text().toString() // сейчас
            day[1] = n2?.get(3)?.text().toString() // сегодня днем
            day[2] = n2?.get(2)?.text().toString() // сегодня ночью
            day[3] = n2?.get(4)?.text().toString()// завтра ночью
            day[4] = n2?.get(2)?.text().toString() // завтра днем
            day[5] = n3?.text().toString()  // текс погоды
            day[6] = n4?.text().toString() // ветер

//weather text day1
            day[20] = weatherDay1.get(0).toString() // ночь
            day[21] = weatherDay1.get(1).toString() // день
            day[22] = weatherDay1.get(2).toString() // 6
            day[23] = weatherDay1.get(3).toString()// 12
            day[24] = weatherDay1.get(1).toString()// 15
            day[25] = weatherDay1.get(4).toString()// 18
            day[26] = weatherDay1.get(5).toString()// 21


//weather text day2
            day[30] = weatherDay2.get(0).toString() // ночь
            day[31] = weatherDay2.get(1).toString() // день
            day[32] = weatherDay2.get(2).toString() // 6
            day[33] = weatherDay2.get(3).toString()// 12
            day[34] = weatherDay2.get(1).toString()// 15
            day[35] = weatherDay2.get(4).toString()// 18
            day[36] = weatherDay2.get(5).toString()// 21



            day[8] = n2?.get(8)?.text().toString() //6 утра
            day[9] = n2?.get(9)?.text().toString() //9 утра
            day[10] = n2?.get(10)?.text().toString() //12 утра
            day[11] = n2?.get(11)?.text().toString() //15  часов
            day[12] = n2?.get(12)?.text().toString() //18  часов
            day[13] = n2?.get(13)?.text().toString() //21  часов
            day[14] = n5?.text().toString() //время

            //завтра
            day2[1] = n2Day2?.get(2)?.text().toString() // сегодня ночьб
            day2[2] = n2Day2?.get(3)?.text().toString() // сегодня днем
            day2[8] = n2Day2?.get(8)?.text().toString() //6 утра
            day2[9] = n2Day2?.get(9)?.text().toString() //9 утра
            day2[10] = n2Day2?.get(10)?.text().toString() //12 утра
            day2[11] = n2Day2?.get(11)?.text().toString() //15  часов
            day2[12] = n2Day2?.get(12)?.text().toString() //18  часов
            day2[13] = n2Day2?.get(13)?.text().toString() //21  часов
        }
        //вылюта

    }


    //----------------------------------FUN----------------------------------------------


    fun nameCityFun(): String {
        if (nameCity == null) {
            return ""
        } else {
            return nameCity?.text().toString().replace("сегодня", "")
        }
    }


    fun n1fun(): String {
        if (day != null) {
            return day[1]
        } else {
            return ""
        }
    }


    fun n2fun(): String = day[2]

    fun n3fun(): String {

        if (day != null) {
            return day[3]
        } else {
            return ""
        }
    }

    fun n4fun(): String {

        if (day != null) {
            return day[4]
        } else {
            return ""
        }
    }

    //weather day1
    fun n20funNoch1(): String = if (!day.isEmpty())  day.get(20).toString()!! else "" // текст ночь
    fun n21funDay1(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день 15

    fun n22funDay6(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n23funDay9(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n24funDay12(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n25funDay18(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n26funDay21(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день

    //weather day2
    fun n30funNoch1(): String = if (!day.isEmpty())  day.get(20).toString()!! else "" // текст ночь
    fun n31funDay1(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день 15

    fun n32funDay6(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n33funDay9(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n34funDay12(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n35funDay18(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день
    fun n36funDay21(): String = if (!day.isEmpty())  day.get(21).toString()!! else "" //текс день

    fun n0fun(): String = day[0]
    fun n5fun(): String = day[5]

    fun n8fun(): String = day[8]
    fun n9fun(): String = day[9]
    fun n10fun(): String = day[10]
    fun n11fun(): String = day[11]
    fun n12fun(): String = day[12]
    fun n13fun(): String = day[13]


    fun DayDay2(): String = day2[2] // сегодня днем
    fun NochDay2(): String = day2[1] // сегодня ночью

    fun n8funDay2(): String = day2[8] //6 утра
    fun n9funDay2(): String = day2[9] //9 утра
    fun n10funDay2(): String = day2[10] //12 утра
    fun n11funDay2(): String = day2[11]//15  часов
    fun n12funDay2(): String = day2[12] //18  часов
    fun n13funDay2(): String = day2[13] //21  часов





    fun n14funTime(): String {
        if (day[14] == "" || day == null) {
            return "";
        }
        if (day[14][1].toString() != ":") {
            if ((day[14][0].toString() + day[14][1].toString()).toInt() >= 20) {
                return ("noch")
            } else {
                return ("day")
            }
        } else {
            if (day[14][0].toString().toInt() > 6) {
                return ("day")
            } else
                return ("noch")
        }
    }


    fun n6funVeter(): String {
        if (day[6] == null || day[6] == "") {
            return "Нет соединения"
        }
        //var veter = n4.toString()[0]
        when (day[6][0].toString().toInt()) {
            0 -> return "Ветра нет"
            in 1..5 -> return "Легкий ветерок"
            in 6..8 -> return "Умеренный ветер"
            in 8..11 -> return "Ветренно"
            in 11..14 -> return "Сильный ветер"
            in 15..19 -> return "Очень сильный ветер"
            in 20..32 -> return "Сильный Шторм"
            in 33..20 -> return "Ураган"
            else -> return ""

        }
    }


}










