package com.example.e_waste.activity.nearestfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_waste.entity.DataDummyPlace;
import com.example.e_waste.adapter.NearestAdapter;
import com.example.e_waste.entity.NearestPlace;
import com.example.e_waste.R;

import java.util.ArrayList;

public class NearestFragment extends Fragment {

    private ArrayList<NearestPlace> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nearest, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_nearest_place);
        list.addAll(DataDummyPlace.getListDataPlaces());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        NearestAdapter nearestAdapter = new NearestAdapter(getContext());
        nearestAdapter.setPlaces(list);
        recyclerView.setAdapter(nearestAdapter);
        return view;
    }

}
