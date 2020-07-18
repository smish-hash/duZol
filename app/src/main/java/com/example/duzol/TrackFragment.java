package com.example.duzol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TrackFragment extends Fragment {

    public TrackFragment() {
        // Required empty public constructor
    }

    private RecyclerView trackRecyclerView;
    private TrackAdapter trackAdapter;
    List<TrackModel> trackModelList;
    ImageView track_del_btn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track, container, false);

        trackRecyclerView = view.findViewById(R.id.trackRecyclerView);

        LinearLayoutManager tracklayoutManager = new LinearLayoutManager(getActivity());
        trackRecyclerView.setLayoutManager(tracklayoutManager);

        trackAdapter =  new TrackAdapter(initTrack());
        trackRecyclerView.setAdapter(trackAdapter);
        trackAdapter.notifyDataSetChanged();

        track_del_btn = (ImageView) view.findViewById(R.id.track_delete_img);
        track_del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Deletes Track Record\nNot functional now",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private List<TrackModel> initTrack() {
        trackModelList = new ArrayList<>();
        trackModelList.add(new TrackModel("Judgement Day","19 July, 10 AM, it all comes down to this 🤞"));
        trackModelList.add(new TrackModel("Can't believe I did it","19 July, 06:13 AM, Music is your best friend"));
        trackModelList.add(new TrackModel("Importing all files and finalising design","18 July, 09:00 PM, I can sleep later"));
        trackModelList.add(new TrackModel("Now comes the fun part","18 July, 09:00 AM, MotionLayout(It's super cool)"));
        trackModelList.add(new TrackModel("Ok just keep going","17 July, 07:34 AM, Drawers and Multiple Recycler Views"));
        trackModelList.add(new TrackModel("I guess, let's try (God help me)","16 July, 03:00 PM, Splash and Intro"));
        trackModelList.add(new TrackModel("Can I do it? seems difficult","16 July, 11:16 AM :/"));

        return trackModelList;
    }
}