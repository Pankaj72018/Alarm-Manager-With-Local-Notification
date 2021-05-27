package com.example.alarm_manager_timepicker;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.util.Calendar;
import java.util.Date;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {

//    String TAG = "AlarmReceiver";
    private final String CHANNEL_ID = "personal_notifications";
    public static String NOTIFICATION_MESSAGE = "notificationMessage";
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {



        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentInfo("content info")
                .setContentTitle("Alarm Service")
                .setContentText("Today Have A Nice Day!!!")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.clocl)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher_round));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("1","my_channel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.setLightColor(Color.green(1));
            channel.setShowBadge(true);
            manager.createNotificationChannel(channel);
            builder.setChannelId("1");
        }

        Notification n = builder.build();
        manager.notify(1, n);

//        n.flags |= Notification.FLAG_AUTO_CANCEL;
//
//        manager.notify(102938, n);


//        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {


            Date currentTime = Calendar.getInstance().getTime();
            Toast.makeText(context, "" + currentTime, Toast.LENGTH_LONG).show();

            Log.e("GetTheDatabase", "onReceive: " + currentTime);

//            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
//            Ringtone r = RingtoneManager.getRingtone(context, notification);
//            r.play();
//
//            Vibrator vibrator = (Vibrator) context
//                    .getSystemService(Context.VIBRATOR_SERVICE);
//            vibrator.vibrate(5000);
//
//            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//            Intent notificationIntent = new Intent(context, MainActivity.class);
//            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//            NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
//                    .setContentTitle("Reminder")
//                    .setContentText("You need to eat")
//                    .setWhen(System.currentTimeMillis())
//                    .setContentIntent(pendingIntent);
//
//            notificationManager.notify(1, mNotifyBuilder.build());
//        }
    }
}

