import android.util.Log
import com.music.activity.day
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.junit.Assert
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun useAppContext() {

        println()
        lateinit var doc: Document
        lateinit var doc2: Document
        lateinit var docTime: Document
        lateinit var dayPogoda1: Document
        lateinit var n3: Element
        lateinit var n4: Element
        lateinit var n2: Elements
        lateinit var docdaytest: Document
        lateinit var docday1: Document
        var time: Int = 0;


        doc = Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/")
            .data("class", "input js-input").get()

        doc2 = Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/now")
            .data("class", "input js-input").get()

        docTime = Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/now")
            .data("class", "day").get()

        docday1 = Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/now")
            .data("class", "row-item").get()

        docdaytest = Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/tomorrow/")
            .data("class", "values").get()





        dayPogoda1 = Jsoup.connect("https://www.gismeteo.ru/weather-rostov-na-donu-5110/now")
            .data("class", "weather-icon tooltip").get()





//        var elementList: Elements = doc.getElementsByClass("unit unit_temperature_c")
//        var input: Elements = doc.body().getElementsByClass("input js-input")

        n2 = doc.getElementsByAttributeValue("class", "unit unit_temperature_c") // список грудусов
        n3 = doc2.getElementsByAttributeValue("class", "now-desc").get(0) // текс погоды
        n4 = doc2.getElementsByAttributeValue("class", "unit unit_wind_m_s").get(0) //ветер
        var n5 = doc2.getElementsByAttributeValue("class", "day").get(0) //время

        var n5t = docdaytest.getElementsByAttributeValue("class", "unit unit_temperature_c") //время

        var n6day1 = doc2.getElementsByAttributeValue("class", "row-item") //ясно итд
        var day1 = doc2.getElementsByAttributeValue("class", "weather-icon tooltip") //ясно итд
        var name = doc2.getElementsByAttributeValue("class","page-title")
        println(n5t.text())

        day[0] = n2[0].text() // сейчас
        day[1] = n2[3].text() // сегодня днем
        day[2] = n2[2].text() // сегодня ночью
        day[3] = n2[4].text() // завтра ночью
        day[4] = n2[4].text() // завтра днем
        day[5] = n3.text()  // текс погоды
        day[6] = n4.text() // ветер

        day[8] = n2[8].text() //6 утра
        day[9] = n2[9].text() //9 утра
        day[10] = n2[10].text() //12 утра
        day[11] = n2[11].text() //15  часов
        day[12] = n2[12].text() //18  часов
        day[13] = n2[13].text() //21  часов
        day[14] = n5.text() // time


        fun n1fun(): String = day[1]
        fun n2fun(): String = day[2]
        fun n3fun(): String = day[3]
        fun n4fun(): String = day[4]
        fun n0fun(): String = day[0]
        fun n5fun(): String = day[5]

        fun n8fun(): String = day[8]
        fun n9fun(): String = day[9]
        fun n10fun(): String = day[10]
        fun n11fun(): String = day[11]
        fun n12fun(): String = day[12]
        fun n13fun(): String = day[13]

        var name2 = name.text().toString().replace("сейчас","")
        println(name2)
        println(dayPogoda1.text().toString()[7])
        println(dayPogoda1.text())
        println(n2.text())
        println(n3.text())
        println(n4.text())
        println(n4.text())
        println(n5.text())
        fun n14fun() {

        if(day[14][0].toString().toInt()!=0) {
            if ((day[14][0].toString() + day[14][1].toString()).toInt() >= 20) {
                println((day[14][0].toString() + day[14][1].toString()).toInt() + 1)
                println("noch")
            } else {
                println("day")
            }
        }else{
            println("noch")
        }

    }
        n14fun()

    }
}