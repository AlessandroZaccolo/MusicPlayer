package com.example.musicplayer.view.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.musicplayer.R;
import com.example.musicplayer.Utils.Utils;
import com.example.musicplayer.data.SongItem;
import com.example.musicplayer.view.adapter.FragmentCommunication;
import com.example.musicplayer.view.adapter.SongRecycleViewAdapter;

import java.util.List;

public class FirstFragment extends Fragment implements View.OnClickListener{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.first_fragment, container, false);

        List<SongItem> songItems = Utils.getSongsData();

        final RecyclerView recyclerView = root.findViewById(R.id.activity_second_rv_data);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, RecyclerView.VERTICAL));
        recyclerView.setAdapter(new SongRecycleViewAdapter(recyclerView.getContext(), songItems));

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
