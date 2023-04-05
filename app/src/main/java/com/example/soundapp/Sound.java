package com.example.soundapp;

import android.graphics.drawable.Drawable;

import androidx.annotation.RawRes;

public class Sound {
    String sounder;
    String soundName;
    int img;
    int sound;

    public Sound(String sounder, String soundName, int img, int sound) {
        this.sounder = sounder;
        this.soundName = soundName;
        this.img = img;
        this.sound = sound;
    }

    public String getSounder() {
        return sounder;
    }

    public void setSounder(String sounder) {
        this.sounder = sounder;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
