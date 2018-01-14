package com.javahelps.sunshine;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean isDualMode ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.container);
        isDualMode = frameLayout!= null ;
        if (isDualMode){
            FragmentManager fragmentManager = getSupportFragmentManager();

            ForecastFragment fragment = (ForecastFragment) fragmentManager.findFragmentById(R.id.container);

            if(fragment == null){

                fragment = new ForecastFragment();

                fragmentManager.beginTransaction().add(R.id.container,fragment).commit();
            }
        }
    }

}
