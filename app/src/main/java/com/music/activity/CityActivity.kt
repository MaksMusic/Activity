package com.music.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.music.activity.databinding.ActivityCtityBinding

class CityActivity : AppCompatActivity() {
    lateinit var binding: ActivityCtityBinding
    lateinit var spinner:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCtityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinerArray()
        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    0 -> Toast.makeText(applicationContext,"светлая",Toast.LENGTH_LONG).show()
                    1 -> Toast.makeText(applicationContext,parent?.selectedItem.toString(),Toast.LENGTH_LONG).show()
                    else -> Toast.makeText(applicationContext,"nuul",Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }



    fun spinerArray(){
        spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.settingStyle,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }



}