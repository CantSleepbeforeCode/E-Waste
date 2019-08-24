package com.example.e_waste;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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
        categoryViewHolder.tvName.setText(getNearestPlaces().get(position).getName());
        categoryViewHolder.tvDescription.setText(getNearestPlaces().get(position).getDescription());
        categoryViewHolder.tvRange.setText(getNearestPlaces().get(position).getRange());
        categoryViewHolder.tvPercentage.setText(getNearestPlaces().get(position).getPercentage());

        Glide.with(context)
                .load(getImage(getNearestPlaces().get(position).getImageBin()))
                .apply(new RequestOptions().override(60, 60).centerCrop().placeholder(R.color.colorAccent))
                .into(categoryViewHolder.imageItem);

        categoryViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NavigationActivity.class);
                intent.putExtra("latitude", getNearestPlaces().get(position).getLatitude());
                intent.putExtra("longtitude", getNearestPlaces().get(position).getLongtitude());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getNearestPlaces().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imageItem;
        TextView tvName, tvDescription, tvRange, tvPercentage;
        ConstraintLayout constraintLayout;

        public CategoryViewHolder(@NonNull View view) {
            super(view);
            imageItem = view.findViewById(R.id.item_image);
            tvName = view.findViewById(R.id.item_name);
            tvDescription = view.findViewById(R.id.item_description);
            tvRange = view.findViewById(R.id.item_range);
            tvPercentage = view.findViewById(R.id.item_percentage);
            constraintLayout = view.findViewById(R.id.base_area);
        }
    }

    private int getImage(String image) {
        return context.getResources().getIdentifier(image, "drawable", context.getPackageName());
    }
}
