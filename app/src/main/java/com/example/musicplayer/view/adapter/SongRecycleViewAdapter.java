package com.example.musicplayer.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.data.SongItem;
import com.example.musicplayer.view.ui.AudioPlayerActivity;


import java.util.List;

public class SongRecycleViewAdapter extends RecyclerView.Adapter<SongRecycleViewAdapter.SongViewHolder> {

    private Context ctx;
    private List<SongItem> songItems;


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


        return new SongViewHolder(ctx, songItems, view);
    }






    @Override
    public void onBindViewHolder(@NonNull final SongViewHolder holder, int position) {



        holder.songImage.setImageResource(ctx.getResources().getIdentifier(
                songItems.get(position).getSongImage(),"drawable", ctx.getPackageName()));
        holder.songTitle.setText(songItems.get(position).getSongTitle());
        holder.songCountry.setText(songItems.get(position).getSongCountry());
        holder.songDuration.setText(songItems.get(position).getSongDuration());
    }


    class SongViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{



        Context ctx;
        List<SongItem> songItemList;


        private ImageView songImage;
        private TextView songTitle;
        private TextView songCountry;
        private TextView songDuration;

        public SongViewHolder(@NonNull Context context, List<SongItem> songs, View itemView){
            super(itemView);

            ctx = context;
            songItemList = songs;

            this.songImage = itemView.findViewById(R.id.custom__adapter_activity_second__img__song);
            this.songTitle = itemView.findViewById(R.id.custom_adapter_activity_second__title__song);
            this.songCountry = itemView.findViewById(R.id.custom_adapter_activity_second__tv__country);
            this.songDuration = itemView.findViewById(R.id.custom_adapter_activity_second__tv__duration);

            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {

            int itemPosition = getAdapterPosition();

            Toast.makeText(ctx, songItemList.get(itemPosition).getSongTitle(), Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(ctx, AudioPlayerActivity.class);
            intent.putExtra("song_position", itemPosition);
            ctx.startActivity(intent);


        }




    }


    @Override
    public int getItemCount() {
        return songItems.size();
    }




}
