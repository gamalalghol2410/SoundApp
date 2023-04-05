package com.example.soundapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;


public class SoundService extends IntentService {

MediaPlayer mediaPlayer;
    public SoundService() {
        super("SoundService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("ttt",intent+"");

        if (intent!=null){
    int sound = intent.getIntExtra("sound",0);

    mediaPlayer=MediaPlayer.create(getApplicationContext(),sound);
    Toast.makeText(getApplicationContext(), "dfdfd", Toast.LENGTH_SHORT).show();
    if (!mediaPlayer.isPlaying()){
        mediaPlayer.start();
    }
}
    }


}