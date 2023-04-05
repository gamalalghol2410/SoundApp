package com.example.soundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soundapp.databinding.ActivitySoundBinding;

import java.util.concurrent.TimeUnit;

public class SoundActivity extends AppCompatActivity {
    ActivitySoundBinding binding;
   static MediaPlayer mediaPlayer;
static TextView maxTime,startTime;
    static ProgressBar Progresssound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySoundBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
maxTime=binding.duration;
        startTime=binding.startDuration;

        Progresssound=binding.progressBar;
        binding.name.setText(intent.getStringExtra("sounder"));
        binding.sound.setText(intent.getStringExtra("name"));

binding.imageView2.setImageResource(intent.getIntExtra("img",0));
mediaPlayer=MediaPlayer.create(this,intent.getIntExtra("sound",0));
        String time = String.format("%02d : %02d ",
                TimeUnit.MILLISECONDS.toMinutes(mediaPlayer.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(mediaPlayer.getDuration()))
        );
        Log.d("ttt","getDuration:"+mediaPlayer.getDuration()+"");
binding.progressBar.setMax((int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration()));
binding.duration.setText(time);
binding.play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intentService=new Intent(SoundActivity.this,MyService.class);

        intentService.putExtra("sound",intent.getIntExtra("sound",0));
     Log.d("ttt",intentService.getIntExtra("sound",0)+"");
        startService(intentService);
    }
});


    }
}