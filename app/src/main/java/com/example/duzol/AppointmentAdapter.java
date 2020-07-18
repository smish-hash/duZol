package com.example.duzol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    private List<AppointmentModel> appointmentModelList;

    public AppointmentAdapter(List<AppointmentModel> appointmentModelList) {
        this.appointmentModelList = appointmentModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        String title = appointmentModelList.get(position).getAppointmentTitle();
        String time = appointmentModelList.get(position).getAppointmentTime();
        String date = appointmentModelList.get(position).getAppointmentDate();
        int image = appointmentModelList.get(position).getAppointmentImg();


        holder.setAppointmentdate(date);
        holder.setAppointmenttime(time);
        holder.setAppointmenttitle(title);
        holder.setAppointmentimg(image);

    }

    @Override
    public int getItemCount() {
        return appointmentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        private TextView appointmenttitle,appointmentdate,appointmenttime;
        private ImageView appointmentimg;
        public ViewHolder( View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.appointment_recyclerview);
            appointmenttitle = itemView.findViewById(R.id.Appointment_title_tv);
            appointmentdate = itemView.findViewById(R.id.appointment_date_tv);
            appointmenttime = itemView.findViewById(R.id.Appointment_time_tv);
            appointmentimg = itemView.findViewById(R.id.appointment_img);
        }
        private void setAppointmenttitle(String title){
            appointmenttitle.setText(title);
        }

        private void setAppointmentdate(String date){
            appointmentdate.setText(date);
        }

        private void setAppointmenttime(String time){
            appointmenttime.setText(time);
        }
        private void setAppointmentimg(int image){
            appointmentimg.setImageResource(image);
        }
    }
}
