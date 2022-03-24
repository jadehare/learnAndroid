package com.jadehare.earthquake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.jadehare.earthquake.data.Earthquake;
import com.jadehare.earthquake.fragment.EarthquakeListFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EarthquakeMainActivity extends AppCompatActivity {
    private final static String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";
    EarthquakeListFragment earthquakeListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_main);

        FragmentManager sfm = getSupportFragmentManager();
        // Android会自动重新添加先前在配置更改后添加的任何Fragment，因此只有在不是自动重启时才添加
        if(savedInstanceState == null){
            FragmentTransaction ft = sfm.beginTransaction();
            this.earthquakeListFragment = new EarthquakeListFragment();
            ft.add(R.id.main_activity_frame,earthquakeListFragment,TAG_LIST_FRAGMENT);
            ft.commitNow();
        }else{
            earthquakeListFragment = (EarthquakeListFragment) sfm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        Date now = Calendar.getInstance().getTime();
        ArrayList<Earthquake> dummyQuakes = new ArrayList<>();
        dummyQuakes.add(new Earthquake("0",now,"San Jose",null,7.3,null));
        dummyQuakes.add(new Earthquake("1",now,"LA",null,6.5,null));
        earthquakeListFragment.setEarthquakes(dummyQuakes);
    }
}