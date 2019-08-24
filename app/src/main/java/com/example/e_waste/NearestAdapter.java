package com.example.e_waste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NearestAdapter extends RecyclerView.Adapter<NearestAdapter.CategoryViewHolder> {
    private final Context context;
    private ArrayList<NearestPlace> nearestPlaces;

    public NearestAdapter(Context context) {
        this.context = context;
    }

    public void setPlaces(ArrayList<NearestPlace> nearestPlaces) {
        this.nearestPlaces = nearestPlaces;
    }

    public ArrayList<NearestPlace> getNearestPlaces() {
        return nearestPlaces;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nearest_box, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {

    }

    @Override
    public int getItemCount() {
        return getNearestPlaces().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        public CategoryViewHolder(@NonNull View view) {
            super(view);
        }
    }
}
