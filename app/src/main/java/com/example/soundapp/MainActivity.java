package com.example.soundapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
TabLayout tabLayout;
ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager2);

        SoundsFragment soundsFragment=new SoundsFragment();
        AlbumsFragment albumsFragment=new AlbumsFragment();

        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();

        fragmentArrayList.add(soundsFragment);
        fragmentArrayList.add(albumsFragment);



        PagerAdapter pagerAdapter=new PagerAdapter(this,fragmentArrayList);

        viewPager2.setAdapter(pagerAdapter);

            String[] fragmentNames={"Sounds","Albums"};
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragmentNames[position]);
            }
        }).attach();






    }


}