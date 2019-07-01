package com.example.musicplayer.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView detailTitle;
    TextView detail;
    List<SongItem> songItems = Utils.getSongsData();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_song);


        manageDetails(getPositionIntent());


    }


    private int getPositionIntent(){
        Intent rcv = getIntent();

        return rcv.getIntExtra("song_position", 0);

    }

    private void manageDetails(int position){

        detailTitle = findViewById(R.id.activity_detail__title__song);
        detailTitle.setText(songItems.get(position).getSongTitle());

        detail = findViewById(R.id.activity_detail__detail);
        detail.setText(songItems.get(position).getSongDetails());

    }


}
