package com.music.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.music.activity.databinding.ActivityCtityBinding
import com.music.activity.utilSharePreferenes.PreferencesManager

class CityActivity : AppCompatActivity() {
    lateinit var binding: ActivityCtityBinding
    lateinit var spinner:Spinner
    lateinit var preferencesManager: PreferencesManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCtityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferencesManager = PreferencesManager(this)
        spinerArray()
        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                when(position){
                    0 -> {
                        preferencesManager.putStringColor("color","while")
                        preferencesManager.putStringColor("colorSetting","while")
                        interfaceDefault()


                    }
                    1 -> {
                        preferencesManager.putStringColor("color","black")
                        preferencesManager.putStringColor("colorSetting","black")
                        interfaceDefault()

                    }
                    else -> Toast.makeText(applicationContext,"null",Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        interfaceDefault()
        exit()

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



   private fun exit(){
        binding.exit.setOnClickListener(){
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun spinnerDefault(){
        var n:String? = preferencesManager.getStringCity("color").toString()
        spinner.setSelection(if (n == "while") 0 else 1)


    }

    fun interfaceDefault(){
        spinnerDefault()
        if (preferencesManager.getStringCity("color").toString() == "black"){
            binding.CL.setBackgroundResource(R.drawable.bgnoch)
            binding.textView.setTextColor(resources.getColor(R.color.white))
        }else{
            binding.CL.setBackgroundResource(R.drawable.bagraund_setting)
            binding.textView.setTextColor(resources.getColor(R.color.black))
        }

    }

}