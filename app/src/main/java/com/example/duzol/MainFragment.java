package com.example.duzol;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


//    Company Recycler View
    private RecyclerView companyRecyclerView;
    private CompanyAdapter companyAdapter;
    List<CompanyModel> companyModelList;
    Button company_viewAll_btn;


//    Banner Slider
    private ViewPager bannerSlidervViewPager;
    private List<BannerSliderModel> bannerSliderModelList;
    private BannerSliderAdapter bannerSliderAdapter;
    int current_page = 2;
    private Timer bannerTimer;
    final private long delayBannerTimer = 3000;
    final private long periodBannerTimer = 3000;

//    Product Recycler View
    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    List<ProductModel> productModelList;
    Button product_viewAll_btn;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//      Company Recycler View
        companyRecyclerView = view.findViewById(R.id.company_recyclerView);
        LinearLayoutManager companylayoutManager = new LinearLayoutManager(getActivity());
        companylayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        companyRecyclerView.setLayoutManager(companylayoutManager);
        companyAdapter = new CompanyAdapter(initCompanyData());
        companyRecyclerView.setAdapter(companyAdapter);
        companyAdapter.notifyDataSetChanged();

        //company view all button
        company_viewAll_btn = (Button) view.findViewById(R.id.view_all_company_btn);
        company_viewAll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Views all the top companies in another activity",Toast.LENGTH_LONG).show();
            }
        });



//        Banner Slider
        bannerSlidervViewPager = view.findViewById(R.id.banner_slider_viewPager);
        bannerSliderAdapter = new BannerSliderAdapter(initBannerData());
        bannerSlidervViewPager.setClipToPadding(false);
        bannerSlidervViewPager.setPageMargin(20);  //20 pixels
        bannerSlidervViewPager.setCurrentItem(current_page);
        bannerSlidervViewPager.setAdapter(bannerSliderAdapter);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                current_page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSlidervViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerAnimation();
//        if users holds the banner timer shall cancel
        bannerSlidervViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                pageLooper();
                stopBannerAnimation();

//                Action Up means user removed the finger
//                Action Down means user is touching
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    startBannerAnimation();
                }
                return false;
            }
        });


//      product Recycler View
        productRecyclerView = view.findViewById(R.id.product_recyclerView);
        LinearLayoutManager productlayoutManager = new LinearLayoutManager(getActivity());
        productlayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        productRecyclerView.setLayoutManager(productlayoutManager);
        productAdapter = new ProductAdapter(initProduct(),new ProductAdapter.onLikeListener(){


            @Override
            public void onLikeClicked(int position) {
//                Toast.makeText(getContext(),"yes?",Toast.LENGTH_SHORT).show();
//                callback performed onCLick
            }
        });
        productRecyclerView.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();

        //product view all button
        product_viewAll_btn = (Button) view.findViewById(R.id.view_all_product_btn);
        product_viewAll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Views all products in another activity",Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }

    private List<CompanyModel> initCompanyData() {
        companyModelList = new ArrayList<>();
        companyModelList.add(new CompanyModel(R.drawable.logo,"Apple"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"Samsung"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"One Plus"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"Huawei"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"LG"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"Nokia"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"Google"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"Vivo"));
        companyModelList.add(new CompanyModel(R.drawable.logo,"Sony Xperia"));

        return companyModelList;

    }

    private List<BannerSliderModel> initBannerData() {
        bannerSliderModelList = new ArrayList<>();

        bannerSliderModelList.add(new BannerSliderModel(R.drawable.arno,"#000000"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.ironman,"#000000"));   //last 2
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.ironman,"#000000"));   //start

        bannerSliderModelList.add(new BannerSliderModel(R.drawable.arno,"#000000"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.arno,"#000000"));

        bannerSliderModelList.add(new BannerSliderModel(R.drawable.ironman,"#000000"));   //emd
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.ironman,"#000000"));
        bannerSliderModelList.add(new BannerSliderModel(R.drawable.arno,"#000000"));      // first 2

        return bannerSliderModelList;
    }

    private List<ProductModel> initProduct() {
        productModelList = new ArrayList<>();
        productModelList.add(new ProductModel(R.drawable.logo,"Apple","Rs.94900"));
        productModelList.add(new ProductModel(R.drawable.logo,"Samsung","Rs.79000"));
        productModelList.add(new ProductModel(R.drawable.logo,"Samsung Galaxy Fold","Rs.99000"));
        productModelList.add(new ProductModel(R.drawable.logo,"Samsung Z flip","Rs.949000"));
        productModelList.add(new ProductModel(R.drawable.logo,"Apple","Rs.949000"));

        return productModelList;
    }


    private void pageLooper(){
        if (current_page == bannerSliderModelList.size()-2){
            current_page = 2;
            bannerSlidervViewPager.setCurrentItem(current_page,false);
        }
        if (current_page == 1){
            current_page = bannerSliderModelList.size()-3;
            bannerSlidervViewPager.setCurrentItem(current_page,false);
        }

    }


    //Automatic banner change
    private void startBannerAnimation(){
        final Handler bannerSliderHandler = new Handler();
        final Runnable bannerUpdate = new Runnable() {
            @Override
            public void run() {
                if (current_page >= bannerSliderModelList.size()){
                    current_page = 1;
                }
                bannerSlidervViewPager.setCurrentItem(current_page++);
            }
        };

        bannerTimer = new Timer();
        bannerTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                bannerSliderHandler.post(bannerUpdate);
            }
        },delayBannerTimer,periodBannerTimer);


    }

    private void stopBannerAnimation(){
        bannerTimer.cancel();
    }
}