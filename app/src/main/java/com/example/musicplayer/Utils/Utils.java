package com.example.musicplayer.Utils;

import com.example.musicplayer.data.SongItem;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<SongItem> getSongsData(){

        String[] songTitles = { "Brazilian Samba", "Country Boy", "Sound of India",
                "Little planet", "Psychedelic", "Relaxing", "The elevator"};

        String[] songImages = {"brazil", "usa", "india",
                "iceland", "southkorea", "indonesia", "brazil"};

        String[] songCountries = {"Brazil", "United States", "India",
                "Iceland", "South Korea", "Indonesia", "Brazil"};

        String[] songDurations = {"04:00", "03:27", "04:13", "06:36", "03:56",
                "4:48", "04:14"};

        String[] songMusic = {"bensoundbrazilsamba", "bensoundcountryboy", "bensoundindia",
                "bensoundlittleplanet", "bensoundpsychedelic", "bensoundrelaxing",
                "bensoundtheelevatorbossanova", "bensoundcountryboy"};

        List<SongItem> songListItems = new ArrayList<>();

        for (int i = 0; i <= songTitles.length - 1; i++){
            SongItem song = new SongItem(songImages[i],
                    songTitles[i], "Country: "+ songCountries[i],
                    "Duration: "+ songDurations[i], songMusic[i]);

            songListItems.add(song);
        }

        return songListItems;


    }



}
