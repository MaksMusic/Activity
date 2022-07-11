package com.music.activity


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
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
    lateinit var thread1: Thread
    lateinit var Gorod: String
    private lateinit var view: View


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        getSupportActionBar()?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        binding.table2.visibility = View.GONE
        update()
        updateBtn()





        binding.newBtn.setOnClickListener {
            Gorod = binding.spinnerCity.getSelectedItem().toString()
            var intent = Intent(this, NewsActivity::class.java)
            intent.putExtra("GOROD", Gorod)
            startActivity(intent)


        }


        binding.BtnCity.setOnClickListener {
            var intent = Intent(this, CityActivity::class.java)

        }

        binding.day2Btn.setOnClickListener {
            binding.table1.visibility = View.GONE
            binding.table2.visibility = View.VISIBLE
            binding.day2Btn.setBackgroundResource(R.drawable.btn_style_click)
            binding.day1Btn.setBackgroundResource(R.drawable.btn_style)
            binding.newBtn.setBackgroundResource(R.drawable.btn_style)

        }

        binding.day1Btn.setOnClickListener {
            binding.table2.visibility = View.GONE
            binding.table1.visibility = View.VISIBLE
            binding.day2Btn.setBackgroundResource(R.drawable.btn_style)
            binding.day1Btn.setBackgroundResource(R.drawable.btn_style_click)
            binding.newBtn.setBackgroundResource(R.drawable.btn_style)
        }
    }


    fun updateBtn() {
        binding.button.setOnClickListener {
            update()
        }
    }
        fun update() {
            //передача выбранного города из спинера
            var t2: T2 = T2(binding.spinnerCity.getSelectedItem().toString())
            Log.e("ll", binding.spinnerCity.getSelectedItem().toString())

            thread1 = Thread(t2)
            thread1.start()

            Handler().postDelayed({
                //nameCity
                binding.rndTitle.text = t2.nameCityFun()
                //nameCity
                Gorod = binding.spinnerCity.getSelectedItem().toString();
                //bacgraund------------------
                if (t2.n14funTime().equals("day")) {
//                    if (Gorod.equals("Ростов-на-Дону")){
//                        binding.table1.setBackgroundColor(resources.getColor(R.color.TL2))
//                        binding.table2.setBackgroundColor(resources.getColor(R.color.TL2))
//                        binding.CL.setBackgroundResource(R.drawable.rostov)
//                    } else {
                    binding.table1.setBackgroundColor(resources.getColor(R.color.TL2))
                    binding.table2.setBackgroundColor(resources.getColor(R.color.TL2))
                    binding.CL.setBackgroundResource(R.drawable.bgday1)
                    //}
                } else {
//                    if (Gorod.equals("Ростов-на-Дону")){
//                        binding.table1.setBackgroundColor(resources.getColor(R.color.TL20))
//                        binding.table2.setBackgroundColor(resources.getColor(R.color.TL20))
//                        binding.CL.setBackgroundResource(R.drawable.rostov1)
//                        binding.day0.setTextColor(R.color.black)
//                        binding.pogoda.setTextColor(R.color.black)
//                        binding.veter.setTextColor(R.color.black)
//                        binding.veter.setTextSize(44.2f)
//
//
//
//                    } else {
                    binding.CL.setBackgroundResource(R.drawable.noch)

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
                binding.day0.text = "Сейчас ${t2.n0fun()} "
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











