package com.music.activity

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.junit.Test


class JsoupTest {

    @Test
    fun testbtnJsoup() {
        println() {
            jsoupTest(
                "https://www.google.com/search?q=%D1%86%D0%B5%D0%BD%D0%B0" +
                        "+%D0%B1%D0%B8%D1%82%D0%BA%D0%BE%D0%B8%D0%BD%D0%B0&oq=wtyf+%2Cbnrjyb&aqs=chrome." +
                        "1.69i57j0i13l9.3588j1j15&sourceid=chrome&ie=UTF-8",
                "class",
                "pclqee".toString()
            )
        }
    }


    fun jsoupTest(link:String,type:String,className:String){
        var bitcoin : Document? = null
        var bitcoinElement: Elements? = null

        //--------------------------получение ,btn --------------------------------------------
        bitcoin = Jsoup.connect(link).data(type,className).get()
        //------------------------присвоение данных------------------------------------------
        bitcoinElement = bitcoin?.getElementsByAttributeValue("class","pclqee")
        //------------------------вывод------------------------------------------
        println(bitcoinElement?.text().toString())

    }

    @Test
    fun updateInfo(){

          var n =  Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/now/").data("class","time").get()
        var n2:Elements? = n.getElementsByAttributeValue("class", "time")!!
        var n3:Elements? = n.getElementsByAttributeValue("class", "now-localdate")!!
        println(n3?.text())
        }

    @Test
    fun testWeater(){
        var url = "https://www.gismeteo.ru/weather-rostov-na-donu-5110/"
        var n =  Jsoup.connect(url).get()
        var n100 = n.select("div[class=weather-icon tooltip]")[0].attr("data-text")
         var nn = n.select("div[class=weather-icon tooltip]")[0].attr("data-text").toString()
             .substringAfter(',').trim() //


        var n101 = n.select("div[class=weather-icon tooltip]")
        var textWeter = n100?.toString()?.substringAfter(',')?.trim()

        println("n100 " + n100?.toString())
        println("n100 substringAfter " + n100?.substringAfter(',')?.trim())
        println("n101 " + n101?.toString())
        //0 ночь
        //2 6 утра

//        var n2:Elements? = n.getElementsByAttributeValue("class", "weather-icon tooltip")!!
//        var n3:Elements? = n.getElementsByAttributeValue("class", "now-localdate")!!
//        println(n2?.text())
    }


    @Test
    fun updateInfo3(){

        var n =  Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/").data("class","row-item").get()
        var n2:Elements? = n.getElementsByAttributeValue("class", "row-item")!!

        println(n2?.text())
    }


}