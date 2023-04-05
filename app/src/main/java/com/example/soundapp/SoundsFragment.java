package com.example.soundapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SoundsFragment extends Fragment implements OnItemClick {
ArrayList<Sound> soundArrayList;
    public SoundsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sounds, container, false);
RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
        soundArrayList=new ArrayList<>();
        Sound s1=new Sound("Gamal","Clamp",R.drawable.toast_icon,R.raw.clamp);
        soundArrayList.add(s1);
        Sound s2=new Sound("Ahmed","Wrong",R.drawable.toast_icon,R.raw.wrong);
        soundArrayList.add(s2);
        SoundAdapter soundAdapter=new SoundAdapter(soundArrayList,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
       recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(soundAdapter);

        return view;
    }

    @Override
    public void SetOnItemClick(Sound sound) {


        Intent intent=new Intent(getContext(),SoundActivity.class);
        Toast.makeText(getContext(), sound.getSoundName(), Toast.LENGTH_SHORT).show();
        intent.putExtra("name", sound.getSoundName());
        intent.putExtra("img", sound.getImg());
        intent.putExtra("sound", sound.getSound());
        intent.putExtra("sounder", sound.getSounder());

       startActivity(intent);
    }
}