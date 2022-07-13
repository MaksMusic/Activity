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
    fun testbtnJsoup(){
        jsoupTest("https://www.google.com/search?q=%D1%86%D0%B5%D0%BD%D0%B0" +
                "+%D0%B1%D0%B8%D1%82%D0%BA%D0%BE%D0%B8%D0%BD%D0%B0&oq=wtyf+%2Cbnrjyb&aqs=chrome." +
                "1.69i57j0i13l9.3588j1j15&sourceid=chrome&ie=UTF-8",
           " class",
            "pclqee")
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
        println(n2!![1])
        }




}