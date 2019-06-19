package com.example.musicplayer.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.io.IOException;

public class MusicPlayerService extends Service implements MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener,
MediaPlayer.OnInfoListener{

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

            Toast.makeText(this, "Playing song "+ data, Toast.LENGTH_LONG).show();


            createAndConfigMediaPlayer(data);
        }
        if (mediaPlayerInService.isPlaying()) {

            Toast.makeText(this, "Song is paused", Toast.LENGTH_LONG).show();


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

        Toast.makeText(this, "it is playing "+ mediaPath, Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return false;
    }
}
