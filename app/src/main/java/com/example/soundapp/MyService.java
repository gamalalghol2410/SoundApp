package com.example.soundapp;

import static com.example.soundapp.SoundActivity.mediaPlayer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.security.Provider;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    public static final String ID_CHANNEL = "nc";
    Handler handler;
    Runnable runnable;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


         handler = new Handler();
         runnable = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer.isPlaying()) {

                    SoundActivity.Progresssound.setProgress((int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getCurrentPosition())+1);
                    SoundActivity.startTime.setText((int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getCurrentPosition())+1+"");
                    Log.d("ttt","getCurrentPosition:"+mediaPlayer.getCurrentPosition()+1+"");

                    handler.postDelayed(this, 1000);
                }
            }
        };
        if (!mediaPlayer.isPlaying()) {
            startForeground(1, showNotfication(1));
            mediaPlayer.start();
            updateSeekBar();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopSelf();
            }
        });

        return START_STICKY;
    }
    private void updateSeekBar() {
        handler.postDelayed(runnable, 1000);
    }
    private Notification showNotfication(int i) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel;
            notificationChannel = new NotificationChannel(ID_CHANNEL, "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationChannel.setDescription("وصف القناه");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), ID_CHANNEL);
        builder.setContentTitle("Sound");
        builder.setContentText("Sound is play");
        builder.setSmallIcon(R.drawable.toast_icon);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        Notification notification = builder.build();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        notificationManagerCompat.notify(1, builder.build());
        return notification;
    }

}