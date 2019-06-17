package com.example.musicplayer.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;

import java.io.IOException;
import java.util.List;

public class MusicPlayerService extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayerInService;
    private String data;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service starts", Toast.LENGTH_SHORT).show();

        data = (String) intent.getExtras().get("audio");

        if (mediaPlayerInService == null) {
            createAndConfigMediaPlayer(data);

            Toast.makeText(this, "Playing song"+ data, Toast.LENGTH_SHORT).show();

        }
        if (mediaPlayerInService.isPlaying()) {


            mediaPlayerInService.stop();
        }
        mediaPlayerInService.prepareAsync();


        return START_STICKY;
    }



    private void createAndConfigMediaPlayer(String data) {
        mediaPlayerInService = new MediaPlayer();
        mediaPlayerInService.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayerInService.setOnPreparedListener(this);
        mediaPlayerInService.setOnCompletionListener(this);
        final Uri mediaPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + data);

        Toast.makeText(this, "it is playing"+ mediaPath, Toast.LENGTH_LONG).show();
        try {
            mediaPlayerInService.setDataSource(getApplicationContext(), mediaPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayerInService.stop();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
