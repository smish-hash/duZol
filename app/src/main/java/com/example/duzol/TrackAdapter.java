package com.example.duzol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<TrackModel> trackModelList;

    public TrackAdapter(List<TrackModel> trackModelList) {
        this.trackModelList = trackModelList;
    }

    @NonNull
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.ViewHolder holder, int position) {
        String status = trackModelList.get(position).getTrack_status();
        String info = trackModelList.get(position).getTrack_info();
        holder.setTrack_status(status);
        holder.setTrack_info(info);

    }

    @Override
    public int getItemCount() {
        return trackModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView track_status, track_info;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            track_status = itemView.findViewById(R.id.track_status_tv);
            track_info = itemView.findViewById(R.id.track_status_info_tv);
        }

        private void setTrack_status(String status){
            track_status.setText(status);
        }

        public void setTrack_info(String info) {
            track_info.setText(info);
        }
    }
}
