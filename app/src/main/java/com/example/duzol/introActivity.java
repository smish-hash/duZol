package com.example.duzol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class introActivity extends AppCompatActivity {

    private ViewPager introPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btn_next,btn_get_started,btn_intro_skip;
    Animation btn_get_started_anim;
    int pos_indicator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        make it full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        need to check if this activity has been opened before
        if (restoreIntroPrefs()){
            Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivityIntent);
            finish();
        }

        setContentView(R.layout.activity_intro);

//        hiding the action bar
//        getSupportActionBar().hide();


        tabIndicator = findViewById(R.id.tabIndicator);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_get_started = (Button) findViewById(R.id.btn_get_started);
        btn_get_started_anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.get_started_anim);
        btn_intro_skip = (Button) findViewById(R.id.btn_intro_skip);
        final Vibrator vibrator = (Vibrator) introActivity.this.
                getSystemService(Context.VIBRATOR_SERVICE);


//        dummy intro list
        final List<introItem> mList = new ArrayList<introItem>();
        mList.add(new introItem("Appointment",
                "Description about Appointment.Description about Precribed drugs.Description about Precribed drugs.Description about Precribed drugs",
                R.drawable.citylights));
        mList.add(new introItem("Prescription Drugs",
                "Description about Precribed drugs.bout Precribed drugs.Description about Precribed drubout Precribed drugs.Description about Precribed dru",
                R.drawable.telephone));
        mList.add(new introItem("Drug Informations",
                "Description about drugs...duh!",R.drawable.laptop));


//        setUp viewpager
        introPager = findViewById(R.id.banner_slider_viewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        introPager.setAdapter(introViewPagerAdapter);


//        setUp tabLayout with ViewPager
        tabIndicator.setupWithViewPager(introPager);

//        next button click listener
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos_indicator = introPager.getCurrentItem();
                if (pos_indicator < mList.size()){
                    vibrator.vibrate(5);
                    pos_indicator ++;
                    introPager.setCurrentItem(pos_indicator);
                }

                if (pos_indicator == mList.size()-1){     //end of intro_slider
//                    hide the next button and show the get started button
                    introEnd();
                }

            }
        });

//        tabLayout change listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    introEnd();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(10);
                //open main activity
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);

                saveIntroPrefs();
                finish();

            }
        });

        btn_intro_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);

                saveIntroPrefs();
                finish();

            }
        });



    }

    private boolean restoreIntroPrefs(){
        SharedPreferences introPref = getApplicationContext().getSharedPreferences("myIntroPrefs",
                MODE_PRIVATE);
        Boolean hasIntroActivityOpenedBefore = introPref.getBoolean("isIntroOpened",false);
        return hasIntroActivityOpenedBefore;

    }

    private void saveIntroPrefs() {
        SharedPreferences introPref = getApplicationContext().getSharedPreferences("myIntroPrefs",
                MODE_PRIVATE);
        SharedPreferences.Editor introPrefEditor= introPref.edit();
        introPrefEditor.putBoolean("isIntroOpened",true);
        introPrefEditor.commit();

    }

    private void introEnd() {
        btn_next.setVisibility(View.INVISIBLE);
        btn_get_started.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btn_get_started.setAnimation(btn_get_started_anim);
    }
}