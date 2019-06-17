package com.example.musicplayer.view.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;

import java.util.List;

public class SecondFragment extends Fragment implements View.OnClickListener {




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.second_fragment, container, false);

        return root;
    }

    @Override
    public void onClick(View v) {

        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
        List<SongItem> songItems = Utils.getSongsData();
        int position = viewHolder.getAdapterPosition();

        String title = songItems.get(position).getSongCountry();

        Log.d("title", title);

    }
}
