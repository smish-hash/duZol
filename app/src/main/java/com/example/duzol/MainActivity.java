package com.example.duzol;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    private static final int MAIN_FRAGMENT = 0;
    private static final int TRACK_FRAGMENT = 1;
    private static final int APPOINTMENT_FRAGMENT = 2;

    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    private static int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView!=null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = (FrameLayout) findViewById(R.id.main_frameLayout);
        setFragment(new MainFragment(),MAIN_FRAGMENT);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == MAIN_FRAGMENT){  // menu inflates only if user is in main fragment
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_bag) {
            Toast.makeText(this, "Bag clicked", Toast.LENGTH_SHORT).show();
//            myWishList();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setChecked(true);

        switch (id) {
            case R.id.nav_home:
                setFragment(new MainFragment(),MAIN_FRAGMENT);break;
            case R.id.nav_track:myTrack();break;
            case R.id.nav_appointment:
                myAppointment();
                break;
            case R.id.nav_feedback:
                Intent intent = new Intent(this, feedBackActivity.class);
                navigationView.getMenu().getItem(3).setChecked(true);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void myAppointment() {
        setFragment(new AppointmentFragment(),APPOINTMENT_FRAGMENT);
        navigationView.getMenu().getItem(2).setChecked(true);
    }

    private void myTrack(){
        setFragment(new TrackFragment(),TRACK_FRAGMENT);
        navigationView.getMenu().getItem(1).setChecked(true);
    }


    private void setFragment(Fragment fragment, int fragmentNum){
        currentFragment = fragmentNum;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(frameLayout.getId(),fragment);
        ft.commit();
    }
}