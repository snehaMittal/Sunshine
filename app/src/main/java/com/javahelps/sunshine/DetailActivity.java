package com.javahelps.sunshine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    Boolean isDualMode ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
        isDualMode = frameLayout!= null ;
        if (isDualMode){
            FragmentManager fragmentManager = getSupportFragmentManager();

            ForecastFragment fragment = (ForecastFragment) fragmentManager.findFragmentById(R.id.container2);

            if(fragment == null){

                fragment = new ForecastFragment();

                fragmentManager.beginTransaction().add(R.id.container2,fragment).commit();
            }
        }
    }

}
