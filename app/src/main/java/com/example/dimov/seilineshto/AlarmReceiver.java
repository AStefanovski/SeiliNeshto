package com.example.dimov.seilineshto;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 0;


    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Create the content intent for the notification, which launches this activity
        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                .setContentTitle("Se ili neshto")
                .setContentText("Igraj")
                .setContentIntent(contentPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);


        //Deliver the notification
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}