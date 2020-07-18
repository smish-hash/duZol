package com.example.duzol;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private int ficon = 0;
    private List<ProductModel> productModelList;
    private onLikeListener monLikeListener;

    public ProductAdapter(List<ProductModel> productModelList, onLikeListener onLikeListener) {
        this.productModelList = productModelList;
        this.monLikeListener = onLikeListener;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_itemlist,parent,false);
        return new ViewHolder(view,monLikeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder holder, int position) {
        String name = productModelList.get(position).getProductName();
        String price = productModelList.get(position).getProductPrice();
        int icon = productModelList.get(position).getProductImage();
        holder.setProductname(name);
        holder.setProductprice(price);
        holder.setProducticon(icon);

    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView producticon,fav_icon;
        private TextView productname;
        private TextView productprice;
        private onLikeListener onlikelistener;

        public ViewHolder(@NonNull View itemView, onLikeListener onlikelistener) {
            super(itemView);
            producticon = itemView.findViewById(R.id.product_icon);
            productname = itemView.findViewById(R.id.product_name);
            productprice = itemView.findViewById(R.id.product_price);
            fav_icon = itemView.findViewById(R.id.like_btn);
            this.onlikelistener = onlikelistener;

            fav_icon.setOnClickListener(this);
        }
        private void setProducticon(int icon){
            producticon.setImageResource(icon);
        }

        public void setProductname(String name) {
            productname.setText(name);
        }

        public void setProductprice(String price) {
            productprice.setText(price);
        }

        @Override
        public void onClick(View view) {
            if (ficon%2==0) {
                fav_icon.setBackground(view.getResources().getDrawable(R.drawable.ic_baseline_favorite_red_24));
            }else {
                fav_icon.setBackground(view.getResources().getDrawable(R.drawable.ic_baseline_favorite_black_24));
            }
            ficon++;
//            Toast.makeText(view.getContext(),"yes?",Toast.LENGTH_SHORT).show();
            onlikelistener.onLikeClicked(getAdapterPosition());
        }
    }

    public interface onLikeListener{
        void onLikeClicked(int position);
    }
}
