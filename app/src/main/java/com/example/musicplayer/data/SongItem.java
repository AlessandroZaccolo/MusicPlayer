package com.example.musicplayer.data;

public class SongItem {


    private String songImage;
    private String songTitle;
    private String songCountry;
    private String songDuration;
    private String songMusic;
    private String songDetails;

    public SongItem(String songImage, String songTitle, String songCountry, String songDuration, String songMusic, String songDetails) {
        this.songImage = songImage;
        this.songTitle = songTitle;
        this.songCountry = songCountry;
        this.songDuration = songDuration;
        this.songMusic = songMusic;
        this.songDetails = songDetails;
    }


    public String getSongImage() {
        return songImage;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getSongCountry() {
        return songCountry;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public String getSongMusic(){ return songMusic; }

    public String getSongDetails() { return songDetails; }


}
