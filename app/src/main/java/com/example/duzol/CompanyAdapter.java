package com.example.duzol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {

    private List<CompanyModel> companyModelList;

    public CompanyAdapter(List<CompanyModel> companyModelList) {
        this.companyModelList = companyModelList;
    }

    @NonNull
    @Override
    public CompanyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyAdapter.ViewHolder holder, int position) {
        String name = companyModelList.get(position).getCompanyName();
        int icon = companyModelList.get(position).getCompanyImage();
        holder.setCompanyname(name);
        holder.setCompanyicon(icon);

    }

    @Override
    public int getItemCount() {
        return companyModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView companyicon;
        private TextView companyname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            companyicon = itemView.findViewById(R.id.company_icon);
            companyname = itemView.findViewById(R.id.company_name);
        }

        private void setCompanyname(String name){
            companyname.setText(name);
        }
        
        private void setCompanyicon(int icon){
            // TODO: 17-07-2020  set company icon
            companyicon.setImageResource(icon);
        }
    }
}
