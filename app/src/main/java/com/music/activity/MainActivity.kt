package com.music.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.music.activity.databinding.ActivityMainBinding
import com.music.activity.databinding.ToolbarBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var bindingToolbarBinding: ToolbarBinding
    lateinit var thread1:Thread
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        bindingToolbarBinding = ToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding.table2.visibility = View.GONE

        binding.BtnCity.setOnClickListener {
            var intent = Intent(this,CityActivity::class.java)
            startActivity(intent)
        }

        binding.day2Btn.setOnClickListener {
            binding.table1.visibility = View.GONE
            binding.table2.visibility = View.VISIBLE
            binding.day2Btn.setBackgroundColor(resources.getColor(R.color.click))
            binding.day1Btn.setBackgroundColor(resources.getColor(R.color.btnNew))

        }

        binding.day1Btn.setOnClickListener {
            binding.table2.visibility = View.GONE
            binding.table1.visibility = View.VISIBLE
            binding.day2Btn.setBackgroundColor(resources.getColor(R.color.btnNew))
            binding.day1Btn.setBackgroundColor(resources.getColor(R.color.click))
        }

        binding.button.setOnClickListener {
            //передача выбранного города из спинера
            var t2: T2  = T2(binding.spinnerCity.getSelectedItem().toString())
            Log.e("ll", binding.spinnerCity.getSelectedItem().toString())

            thread1 = Thread(t2)
            thread1.start()

            Handler().postDelayed({
                //nameCity
                binding.rndTitle.text = t2.nameCityFun()
                //nameCity


                //bacgraund------------------
                if (t2.n14funTime().equals("day")){
                    var n : Int =((Math.random()*2+1)).toInt()
                    if (n<2) {
                        binding.table1.setBackgroundColor(resources.getColor(R.color.TL2))
                        binding.table2.setBackgroundColor(resources.getColor(R.color.TL2))
                        binding.CL.setBackgroundResource(R.drawable.bgday1)
                    }else{
                        binding.CL.setBackgroundResource(R.drawable.bgday2)

                    }
                }else{
                    binding.CL.setBackgroundResource(R.drawable.bgnoch)

                }
                //bacgraund------------------/>



                t2 = T2(binding.spinnerCity.getSelectedItem().toString())
                // погода 1 дня
                binding.Time2DayD1.setText(t2.n1fun())
                binding.Time2NochD1.setText(t2.n2fun())

                binding.Time2D1.setText(t2.n8fun())
                binding.Time3D1.setText(t2.n9fun())
                binding.Time4D1.setText(t2.n10fun())
                binding.Time5D1.setText(t2.n11fun())
                binding.Time6D1.setText(t2.n12fun())
                binding.Time7D1.setText(t2.n13fun())
                // погода 2 дня
                binding.dayd2.setText(t2.DayDay2())
                binding.nochd2.setText(t2.NochDay2())

                binding.Time2D1d2.setText(t2.n8funDay2())
                binding.Time3D1d2.setText(t2.n9funDay2())
                binding.Time4D1d2.setText(t2.n10funDay2())
                binding.Time5D1d2.setText(t2.n11funDay2())
                binding.Time6D1d2.setText(t2.n12funDay2())
                binding.Time7D1d2.setText(t2.n13funDay2())
                

                // погода вверх инфо
                binding.day0.text =  "Сейчас ${t2.n0fun()} "
                binding.pogoda.text = t2.n5fun()
                binding.veter.text = t2.n6funVeter()
            }, 3000)
        }
    }





    //    override fun onStart() {
//        super.onStart()
//        binding.Time2Day1.setText(t3.n1fun())
//        binding.Time2Day2.setText(t3.n2fun())
//
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        binding.Time2Day1.setText(t3.n1fun())
//        binding.Time2Day2.setText(t3.n2fun())
//
//    }
//
//    override fun onResume() {
//        binding.Time2Day1.setText(t3.n1fun())
//        binding.Time2Day2.setText(t3.n2fun())
//
//        super.onResume()
//    }




}




