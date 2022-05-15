package com.music.activity

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class T3News(var Gorod: String) : Runnable {
    var news: Document? = null;
    var newsRub: Elements? = null
    val valuta = Array<String>(10) { "" };
    override fun run() {
        //--------------------------получение данных --------------------------------------------
        news =
            Jsoup.connect("https://finance.rambler.ru/currencies")
                .data("class", "finance-currency-table__cell finance-currency-table__cell--value")
                .get()

        //------------------------присвоение данных------------------------------------------
        newsRub = news?.getElementsByAttributeValue("class", "finance-currency-table__cell finance-currency-table__cell--value")

        Log.e("News21",
            news?.getElementsByAttributeValue("class", "currency-block__marketplace-value")
                .toString() + "                  elseeeeeeeeeeeeeee"
        )

        //-----------------------распределение данных--------------------------------------------
        //valuta[0]= newsRub?.text().toString() для теста
        valuta[0] = "1$ = " + newsRub?.get(29)?.text().toString() + " RUB"
        valuta[1] = "1€ = " + newsRub?.get(11)?.text().toString() + " RUB"
        valuta[2] = "1 Turkish LIRA = " + newsRub?.get(27)?.text().toString() + " RUB"
        valuta[3] = "10 Юаней = " + newsRub?.get(8)?.text().toString() + " RUB"
        Log.e("News1", valuta[0] + "000000000000")

    }

    //-----------------------функции для получения данных--------------------------------------------
    fun rubDollar(): String {
        if (newsRub != null)
            return valuta[0]
        else
            return "no connect"
    }

    fun rubLIR(): String {
        if (newsRub != null)
            return valuta[2]
        else
            return "no connect"
    }
    fun rubUAN(): String {
        if (newsRub != null)
            return valuta[3]
        else
            return "no connect"
    }
    fun rubEuro(): String {
        if (newsRub != null)
            return valuta[1]
        else
            return "no connect"
    }
}