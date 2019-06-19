package com.example.musicplayer.view.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;
import com.example.musicplayer.service.MusicPlayerService;

import java.util.List;


public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txView;
    ImageView img;

    List<SongItem> songItems = Utils.getSongsData();

    private int getPosition(){
        Intent rcv = getIntent();

        return rcv.getIntExtra("song_position", 0);

    }



    public void getIncomingIntent(){

        txView = findViewById(R.id.activity_second__title__song);
        txView.setText(songItems.get(getPosition()).getSongTitle());

        img = findViewById(R.id.activity_third__song__img);
        img.setImageResource(this.getResources().getIdentifier(
                songItems.get(getPosition()).getSongImage(), "drawable", this.getPackageName()));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getIncomingIntent();



        Intent intentService = new Intent(this, MusicPlayerService.class);
        intentService.putExtra("audio", songItems.get(getPosition()).getSongMusic());
        this.startService(intentService);

        Button btnPlay = findViewById(R.id.activity_third__btn__play_or_pause);

        btnPlay.setOnClickListener(this);





    }



    /*

    private void getIncomingIntent(){

        if(getIntent().hasExtra("song_image") && getIntent().hasExtra("song_image")){

            int songImage = getIntent().getIntExtra("song_image", 0);
            String songTitle = getIntent().getStringExtra("song_title");

            setExtras(songImage, songTitle);

        }


    }

    private void setExtras(int songImg, String songTit){

        Log.d("John", "getIncomingIntent");


        ImageView image = findViewById(R.id.act_3_pic);
        TextView title = findViewById(R.id.activity_second__title__song);

        Glide.with(this)
                .asBitmap()
                .load(songImg)
                .into(image);


        title.setText(songTit);

    }

    */




    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.activity_third__btn__play_or_pause){

            Intent intentService = new Intent(this, MusicPlayerService.class);
            intentService.putExtra("audio", songItems.get(getPosition()).getSongMusic());
            this.startService(intentService);


            v.setBackgroundResource(R.drawable.ic_play_arrow);
        }





    }

}
