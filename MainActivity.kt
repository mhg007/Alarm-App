package com.example.helloworldexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tvShowTime : TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveData=SaveData(applicationContext)

        tvShowTime = findViewById(R.id.tvShowTime)
        if(saveData.getHour() > 12){
            tvShowTime.text= String.format("%02d",saveData.getHour() - 12) + " : "+String.format("%02d",saveData.getMinute())+" PM"
        }
        else {
            tvShowTime.text= String.format("%02d",saveData.getHour()) + " : "+String.format("%02d",saveData.getMinute())+" PM"
        }
    }
    fun setAlarm(view:View){
        val popTime= PopTime()
        val fm=supportFragmentManager
        popTime.show(fm,"Select time")
    }
    fun setTime(hours:Int,minutes:Int){
        if(hours > 12){
            tvShowTime.text= String.format("%02d",hours - 12) + " : "+String.format("%02d",minutes)+" PM"
        }
        else{
            tvShowTime.text= String.format("%02d",hours) + " : "+String.format("%02d",minutes)+" AM"
        }
        val saveData=SaveData(applicationContext)
        saveData.SaveData(hours,minutes)
        saveData.setAlarm()
    }
}