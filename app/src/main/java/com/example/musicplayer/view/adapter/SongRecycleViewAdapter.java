package com.example.musicplayer.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicplayer.R;
import com.example.musicplayer.data.SongItem;
import com.example.musicplayer.service.MusicPlayerService;
import com.example.musicplayer.view.ui.SecondActivity;
import com.example.musicplayer.view.ui.SecondFragment;
import com.example.musicplayer.view.ui.ThirdActivity;

import java.util.List;

public class SongRecycleViewAdapter extends RecyclerView.Adapter<SongRecycleViewAdapter.SongViewHolder> implements MediaPlayer.OnPreparedListener {

    private Context ctx;
    private List<SongItem> songItems;




    class SongViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{




        private ImageView songImage;
        private TextView songTitle;
        private TextView songCountry;
        private TextView songDuration;
        private ItemClickListener clickListener;


        public SongViewHolder(@NonNull View itemView){
            super(itemView);

            this.songImage = itemView.findViewById(R.id.custom__adapter_activity_second__img__song);
            this.songTitle = itemView.findViewById(R.id.custom_adapter_activity_second__title__song);
            this.songCountry = itemView.findViewById(R.id.custom_adapter_activity_second__tv__country);
            this.songDuration = itemView.findViewById(R.id.custom_adapter_activity_second__tv__duration);

            itemView.setTag(this);

        }


        public void setClickListener(ItemClickListener itemClickListener) {

            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());


        }


    }

    public SongRecycleViewAdapter(Context context, List<SongItem> objects) {
        this.ctx = context;
        this.songItems = objects;

    }



    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(ctx)
                .inflate(R.layout.custom_adapter_main,parent, false);


        return new SongViewHolder(view);
    }




        //holder.bind(items.get(position), listener);

        @Override
    public void onBindViewHolder(@NonNull final SongViewHolder holder, int position) {



        final int obj = ctx.getResources().getIdentifier(
                songItems.get(position).getSongImage(),
                "drawable",
                ctx.getPackageName());


        holder.songImage.setImageResource(obj);
        holder.songTitle.setText(songItems.get(position).getSongTitle());
        holder.songCountry.setText(songItems.get(position).getSongCountry());
        holder.songDuration.setText(songItems.get(position).getSongDuration());

            Glide.with(ctx)
                    .asBitmap()
                    .load(obj)
                    .into(holder.songImage);



        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View v, int position) {

                Toast.makeText(ctx, "#" + position + " - ", Toast.LENGTH_SHORT).show();



                SecondFragment secondFragment = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putString("song_title", songItems.get(position).getSongTitle());
                secondFragment.setArguments(bundle);

                /*

                Intent intentService = new Intent(ctx, MusicPlayerService.class);
                intentService.putExtra("audio", songItems.get(position).getSongMusic());
                ctx.startService(intentService);



                Intent intent = new Intent(ctx, ThirdActivity.class);
                intent.putExtra("song_image", obj);
                intent.putExtra("song_title", songItems.get(position).getSongTitle());

                ctx.startActivity(intent);

                */

            }
        });


    }


    @Override
    public int getItemCount() {
        return songItems.size();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }




}
