package com.example.helloworldexample

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment

class PopTime : DialogFragment() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var myView= inflater!!.inflate(R.layout.pop_time,container,false)
        var buDone=myView.findViewById(R.id.buDone) as Button
        var picker =myView.findViewById(R.id.tp1) as TimePicker

        buDone.setOnClickListener {
            val ma = activity as MainActivity
            ma.setTime(picker.hour,picker.minute)
            this.dismiss()
        }
        return myView
    }
}