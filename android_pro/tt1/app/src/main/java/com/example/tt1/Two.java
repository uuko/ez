package com.example.tt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class Two extends AppCompatActivity {
    public PreferencesHelperImp preferencesHelperImp;
    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    Toolbar toolbar,toolbartab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
      //  TextView textView=(TextView) findViewById(R.id.text);
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("sharedPreferences", MODE_PRIVATE);
//        String email=sharedPreferences.getString("data","");
       // TextView textView = (TextView)findViewById(R.id.email);
//        textView.setText(email);
        preferencesHelperImp = new PreferencesHelperImp(getApplicationContext());
        String email = preferencesHelperImp.getStringData();

        Log.d("Mainactivity", "onClick: " + email);
        tabLayout=(TabLayout)findViewById(R.id.tabs);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        toolbartab=(Toolbar)findViewById(R.id.toolbartab);
        //setSupportActionBar(toolbar);

        pageAdapter=new PageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new RedFragment(),"Red");
        pageAdapter.addFragment(new GreenFragment(),"Green");
        pageAdapter.addFragment(new BlueFragment(),"Blue");

        viewPager.setAdapter(pageAdapter);
        viewPager.setPageTransformer(true,new DepthPageTransformer());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getWindow().setStatusBarColor(RED);
                        tabLayout.setBackgroundColor(RED);
                        break;
                    case 1:
                        getWindow().setStatusBarColor(GREEN);
                        tabLayout.setBackgroundColor(GREEN);
                        break;
                    case 2:
                        getWindow().setStatusBarColor(BLUE);
                        tabLayout.setBackgroundColor(BLUE);
                        tabLayout.setTabTextColors(ColorStateList.valueOf(WHITE));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override

            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

}
