package com.example.duzol;

public class TrackModel {
    String track_status,track_info;

    public TrackModel(String track_status, String track_info) {
        this.track_status = track_status;
        this.track_info = track_info;
    }

    public String getTrack_status() {
        return track_status;
    }

    public void setTrack_status(String track_status) {
        this.track_status = track_status;
    }

    public String getTrack_info() {
        return track_info;
    }

    public void setTrack_info(String track_info) {
        this.track_info = track_info;
    }
}
