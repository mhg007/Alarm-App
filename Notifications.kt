package com.example.helloworldexample
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService

class Notifications {
    val NOTIFIYTAG = "new request"
    val CHANNEL_ID = "android"
    fun Notify(context: Context,message:String,number:Int){
        val nm=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent=Intent(context,MainActivity::class.java)
        val pIntent : PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder=NotificationCompat.Builder(context,CHANNEL_ID)
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentTitle("Alarm Time")
            .setContentText(message)
            .setNumber(number)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentIntent(pIntent)
            .setAutoCancel(true)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.notify(NOTIFIYTAG, 0, builder.build())
        }else{
            nm.notify(NOTIFIYTAG.hashCode(), builder.build())
        }

    }

}