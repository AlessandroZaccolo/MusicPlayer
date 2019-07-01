package com.example.musicplayer.view.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.musicplayer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = findViewById(R.id.activity_main__btn__see__playlist);
        btnPlay.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.activity_main__btn__see__playlist){
            Intent intent = new Intent(this, SongsListActivity.class);

            startActivityForResult(intent, 101);

        }


    }
}
