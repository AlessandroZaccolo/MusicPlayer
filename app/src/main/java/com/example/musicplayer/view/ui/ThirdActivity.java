package com.example.musicplayer.view.ui;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.musicplayer.R;


public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    String title;
    TextView txView;
    Button btnPause;

    void initViews(){
        Intent rcv = getIntent();
        title = rcv.getStringExtra("song_title");


        txView = findViewById(R.id.activity_third__btn__play_or_pause);

        txView.setText(title);
        

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initViews();
        //getIncomingIntent();

        Button btnPlay = findViewById(R.id.activity_third__btn__play_or_pause);
        btnPlay.setOnClickListener(this);

        /*
        iconPlay = findViewById(R.id.activity_third___btn__play);
        iconPlay.setOnClickListener(this);
        */

    }




    private void getIncomingIntent(){

        if(getIntent().hasExtra("song_image") && getIntent().hasExtra("song_image")){

            int songImage = getIntent().getIntExtra("song_image", 0);
            String songTitle = getIntent().getStringExtra("song_title");

            setExtras(songImage, songTitle);

        }


    }

    private void setExtras(int songImg, String songTit){

        ImageView image = findViewById(R.id.act_3_pic);
        TextView title = findViewById(R.id.activity_second__title__song);


        Glide.with(this)
                .asBitmap()
                .load(songImg)
                .into(image);


        title.setText(songTit);

    }




    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.activity_third__btn__play_or_pause){




            v.setBackgroundResource(R.drawable.ic_play_arrow);
        }





    }

}
