package com.example.musicplayer.view.ui;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;
import com.example.musicplayer.service.MusicPlayerService;

import java.util.List;
import java.util.Random;


public class AudioPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private final String ACTION_PLAY = "PLAY";
    private final String ACTION_PAUSE = "PAUSE";
    TextView txView;
    ImageView img;
    int count = 0;
    Button btnPrev;
    Button btnPlay;


    List<SongItem> songItems = Utils.getSongsData();

    private int getPositionIntent(){
        Intent rcv = getIntent();

        return rcv.getIntExtra("song_position", 0);

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        manageAssets(getPositionIntent());


        btnPlay = findViewById(R.id.activity_third__btn__play_or_pause);
        btnPlay.setOnClickListener(this);

        Button btnNext = findViewById(R.id.activity_third__next__song);
        btnNext.setOnClickListener(this);

        btnPrev = findViewById(R.id.activity_third__previous__song);
        btnPrev.setOnClickListener(this);

        img = findViewById(R.id.activity_third__song__img);
        img.setOnClickListener(this);




    }


    private void manageAssets(int position){


        Toast.makeText(this, "position is "+ position, Toast.LENGTH_LONG).show();

        txView = findViewById(R.id.activity_second__title__song);
        txView.setText(songItems.get(position).getSongTitle());

        img = findViewById(R.id.activity_third__song__img);
        img.setImageResource(this.getResources().getIdentifier(
                songItems.get(position).getSongImage(), "drawable", this.getPackageName()));

        Intent intentService = new Intent(this, MusicPlayerService.class);
        intentService.putExtra("audio", songItems.get(position).getSongMusic());
        intentService.putExtra("action", ACTION_PLAY);
        this.startService(intentService);


        generateNotification(position);


    }










    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.activity_third__btn__play_or_pause){




            Intent intentService = new Intent(this, MusicPlayerService.class);
            intentService.putExtra("audio", songItems.get(getPositionIntent()+count).getSongMusic());
            intentService.putExtra("action", ACTION_PAUSE);
            startService(intentService);


            if (btnPlay.getTag() == null || btnPlay.getTag() == "play"){
                btnPlay.setBackgroundResource(R.drawable.ic_play_arrow);
                btnPlay.setTag("pause");
            } else if (btnPlay.getTag() == "pause"){
                btnPlay.setBackgroundResource(R.drawable.ic_pause);
                btnPlay.setTag("play");
            }


        }

        if(v.getId() == R.id.activity_third__next__song){

            Toast.makeText(this, "Next Song!" +count, Toast.LENGTH_LONG).show();
            if(getPositionIntent() + count != songItems.size() - 1){
                count++;
                int position = getPositionIntent() + count;
                manageAssets(position);
            }

        }


        if(v.getId() == R.id.activity_third__previous__song){

            Toast.makeText(this, "Previous Song!" + count, Toast.LENGTH_LONG).show();
            if(getPositionIntent() != 0){
                count--;
                int position = getPositionIntent() + count;
                manageAssets(position);

            }

        }





    }



    private void generateNotification(final int position) {


        final NotificationManager notification = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);

        final NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "channelId")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(songItems.get(position).getSongTitle())
                        .setContentText(songItems.get(position).getSongCountry())
                        .setContentIntent(getPendingIntentWithRequestCode(23, this, position));

        final RemoteViews customNotification = new RemoteViews(getPackageName(), R.layout.notification_custom);
        customNotification.setTextViewText(R.id.notification_custom__tv__title, songItems.get(position).getSongTitle());
        customNotification.setTextViewText(R.id.notification_custom__tv__body, "Click the notification to read song details");
        builder.setContent(customNotification);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel =
                    new NotificationChannel("NOTIFICATION_CHANNEL_ID",
                            "NOTIFICATION_CHANNEL_NAME",
                            importance);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

            builder.setChannelId("NOTIFICATION_CHANNEL_ID");
            notification.createNotificationChannel(notificationChannel);
        }

        notification.notify(
                new Random().nextInt(4),
                builder.build());

    }




    private PendingIntent getPendingIntentWithRequestCode(int requestCode, Context context, int position) {
        Intent tapActionIntent = new Intent(context, DetailActivity.class);
        tapActionIntent.putExtra("song_position", position);
        return PendingIntent.getActivity(this,
                requestCode,
                tapActionIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
    }





}
