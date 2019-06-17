package com.example.musicplayer.view.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;
import com.example.musicplayer.view.adapter.SongRecycleViewAdapter;

import java.util.List;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        List<SongItem> songItems = Utils.getSongsData();

        final RecyclerView recyclerView = findViewById(R.id.activity_second_rv_data);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
        recyclerView.setAdapter(new SongRecycleViewAdapter(this, songItems));




    }


}
