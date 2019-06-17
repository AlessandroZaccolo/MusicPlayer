package com.example.musicplayer.view.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;

import java.util.List;

public class SecWithFrag extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_with_fragments);
    }

    @Override
    public void onClick(View v) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
        List<SongItem> songItems = Utils.getSongsData();
        int position = viewHolder.getAdapterPosition();

        String title = songItems.get(position).getSongCountry();

        Log.d("title", title);
    }
}
