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

        String[] songDetails = {"Samba is a Brazilian musical genre and dance style, with its roots in Africa via the West African slave trade and African religious traditions, particularly of Angola",
                "Country music is a genre ofAmerican popular music that originated in the Southern United States in the 1920s",
                "The music of India includes multiple varieties of folk music, pop, and Indian classical music. India's classical music tradition, including Hindustani music and Carnatic, has a history spanning millennia and developed over several eras",
                "The music of Iceland includes vibrant folk and pop traditions. Wellknown artists from Iceland include medieval music group Voces Thules, alternative rock band The Sugarcubes, singers Björk and Emiliana Torrini, post-rock band Sigur Rós and indie folk/indie pop band Of Monsters and Men",
                "The Music of South Korea has evolved over the course of the decades since the end of the Korean War, and has its roots in the music of the Korean people, who have inhabited the Korean peninsula for over a millennium. Contemporary South Korean music can be divided into three different main categories: Traditional Korean folk music, popular music, or K-pop, and Western-influenced non-popular music",
                "The music of Indonesia demonstrates its cultural diversity, the local musical creativity, as well as subsequent foreign musical influences that shaped contemporary music scenes of Indonesia. Nearly thousands of Indonesian islands having its own cultural and artistic history and character",
                "Samba is a Brazilian musical genre and dance style, with its roots in Africa via the West African slave trade and African religious traditions, particularly of Angola" };

        List<SongItem> songListItems = new ArrayList<>();

        for (int i = 0; i <= songTitles.length - 1; i++){
            SongItem song = new SongItem(songImages[i],
                    songTitles[i], "Country: "+ songCountries[i],
                    "Duration: "+ songDurations[i], songMusic[i], songDetails[i]);

            songListItems.add(song);
        }

        return songListItems;


    }



}
