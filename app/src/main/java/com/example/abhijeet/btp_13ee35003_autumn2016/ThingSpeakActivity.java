package com.example.abhijeet.btp_13ee35003_autumn2016;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ThingSpeakActivity extends AppCompatActivity {

    private int channeId ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_thing_speak.xml layout file
        setContentView(R.layout.activity_thing_speak);

        channeId = getIntent().getExtras().getInt("channelId");

      //Toast.makeText(this, "channel Id is " + intValue , Toast.LENGTH_LONG).show();

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        // Create an adapter that knows which fragment should be shown on each page
        ThingSpeakPageAdapter adapter = new ThingSpeakPageAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }

    public int getMyData() {
        return channeId;
    }
}
