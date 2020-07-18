package com.example.duzol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppointmentFragment extends Fragment {

    public AppointmentFragment() {
        // Required empty public constructor
    }

    private RecyclerView appointmentRecyclerView;
    private AppointmentAdapter appointmentAdapter;
    List<AppointmentModel> appointmentModelList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        appointmentRecyclerView = view.findViewById(R.id.appointment_recyclerview);
        LinearLayoutManager appointmentlayoutManager = new LinearLayoutManager(getActivity());
        appointmentRecyclerView.setLayoutManager(appointmentlayoutManager);

        appointmentAdapter = new AppointmentAdapter(initAppointment());
        appointmentRecyclerView.setAdapter(appointmentAdapter);
        appointmentAdapter.notifyDataSetChanged();


        return view;
    }

    private List<AppointmentModel> initAppointment() {
        appointmentModelList = new ArrayList<>();
        appointmentModelList.add(new AppointmentModel("Design Meeting",
                "Today","10:00 - 11:30",R.drawable.logo));
        appointmentModelList.add(new AppointmentModel("Design Meeting",
                "Today","10:00 - 11:30",R.drawable.logo));
        appointmentModelList.add(new AppointmentModel("Design Meeting",
                "Today","10:00 - 11:30",R.drawable.logo));
        appointmentModelList.add(new AppointmentModel("Design Meeting",
                "Today","10:00 - 11:30",R.drawable.logo));
        appointmentModelList.add(new AppointmentModel("Design Meeting",
                "Today","10:00 - 11:30",R.drawable.logo));
        appointmentModelList.add(new AppointmentModel("Design Meeting",
                "Today","10:00 - 11:30",R.drawable.logo));

        return appointmentModelList;
    }
}