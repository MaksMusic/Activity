package com.music.activity.utilSharePreferenes

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(Constants.KEY_TABLE_NAME, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    fun putStringCity(key:String?, value:String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
        fun getStringCity(key: String?):String?{
            return sharedPreferences.getString(key,null)
        }

    fun putStringColor(key:String?, value:String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

}