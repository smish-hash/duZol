package com.example.duzol;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class BannerSliderAdapter extends PagerAdapter {

    private List<BannerSliderModel> bannerSliderModelList;

    public BannerSliderAdapter(List<BannerSliderModel> bannerSliderModelList) {
        this.bannerSliderModelList = bannerSliderModelList;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_slider_layout,container,false);
        ConstraintLayout bannerContainer = (ConstraintLayout) view.findViewById(R.id.banner_container);
        bannerContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(bannerSliderModelList.get(position).getBackgroundColor())));
        ImageView bannerImage = (ImageView) view.findViewById(R.id.banner_slider_image);
        bannerImage.setImageResource(bannerSliderModelList.get(position).getBannerImage());
        container.addView(view,0);
        return view;

    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return bannerSliderModelList.size();
    }


}
