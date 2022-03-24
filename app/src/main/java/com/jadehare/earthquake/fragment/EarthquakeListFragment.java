package com.jadehare.earthquake.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jadehare.earthquake.R;
import com.jadehare.earthquake.data.Earthquake;
import com.jadehare.earthquake.view.EarthquakeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment {

    private ArrayList<Earthquake> mEarthquakes = new ArrayList<Earthquake>();
    private RecyclerView mRecyclerView;
    private EarthquakeRecyclerViewAdapter mEarthquakeAdapter = new EarthquakeRecyclerViewAdapter(mEarthquakes);

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earthquake_list,
                container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mEarthquakeAdapter);
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        for (Earthquake earthquake : earthquakes) {
            if (!mEarthquakes.contains(earthquake)) {
                mEarthquakes.add(earthquake);
                mEarthquakeAdapter
                        .notifyItemInserted(mEarthquakes.indexOf(earthquake));
            }
        }
    }
}
