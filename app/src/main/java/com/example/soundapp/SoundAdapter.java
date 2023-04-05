package com.example.soundapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder> {
    ArrayList<Sound> soundArrayList;
Context context;
OnItemClick onItemClick;

    public SoundAdapter(ArrayList<Sound> soundArrayList, OnItemClick onItemClick) {
        this.soundArrayList = soundArrayList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public SoundAdapter.SoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item,parent,false);
        context=parent.getContext();
        SoundViewHolder soundViewHolder=new SoundViewHolder(view);
        return soundViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SoundViewHolder holder, int position) {
        Sound s=soundArrayList.get(position);

        holder.nameSound.setText(s.getSoundName());
        holder.sounder.setText(s.getSounder());
        holder.img.setImageResource(s.getImg());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.SetOnItemClick(s);
            }
        });


    }


    @Override
    public int getItemCount() {
        return soundArrayList.size();
    }

    public class SoundViewHolder extends RecyclerView.ViewHolder {
        TextView nameSound,sounder;
        ImageView img;
        CardView cardView;
        public SoundViewHolder(@NonNull View itemView) {
            super(itemView);
            nameSound=itemView.findViewById(R.id.name_sound);
            sounder=itemView.findViewById(R.id.sounder_name);
            img=itemView.findViewById(R.id.imageView);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }

}
