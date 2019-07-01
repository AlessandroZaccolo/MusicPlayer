package com.example.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

import androidx.annotation.Nullable;


import java.io.IOException;

public class MusicPlayerService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener{

    private MediaPlayer player = null;


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        String data = (String) intent.getExtras().get("audio");
        String action = (String) intent.getExtras().get("action");


        if(player == null && action.equals("PLAY")){
            createAndConfigMediaPlayer(data);

            player.prepareAsync();
        }

        if(player.isPlaying() && action.equals("PAUSE")){
            player.pause();
        } else if(!player.isPlaying() && action.equals("PAUSE")){
            player.start();
        }

        if(player.isPlaying() && action.equals("PLAY")){
            player.stop();
            createAndConfigMediaPlayer(data);
            player.prepareAsync();
        }



        return START_STICKY;
    }


    private void createAndConfigMediaPlayer(String data) {
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setOnPreparedListener(this);
        final Uri mediaPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + data);

        try {
            player.setDataSource(getApplicationContext(), mediaPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}
