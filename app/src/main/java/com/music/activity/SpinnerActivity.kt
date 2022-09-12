package com.music.activity

import android.app.Activity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity :Activity(), AdapterView.OnItemSelectedListener {


    //    fun spinerArray(){
//        val spinner: Spinner = findViewById(R.id.spinner)
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.settingStyle,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//            spinner.onItemSelectedListener
//        }
//    }
//
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        Toast.makeText(applicationContext,parent?.selectedItem.toString(),Toast.LENGTH_LONG).show()
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//
//    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}