package com.example.duzol;

public class AppointmentModel {
    String appointmentTitle,appointmentDate,appointmentTime;
    int appointmentImg;

    public AppointmentModel(String appointmentTitle, String appointmentDate, String appointmentTime, int appointmentImg) {
        this.appointmentTitle = appointmentTitle;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentImg = appointmentImg;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getAppointmentImg() {
        return appointmentImg;
    }

    public void setAppointmentImg(int appointmentImg) {
        this.appointmentImg = appointmentImg;
    }
}
