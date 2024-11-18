package com.example.mealplanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private final List<String> mealList;
    private final List<String> cart;

    public MealAdapter(List<String> mealList, List<String> cart) {
        this.mealList = mealList;
        this.cart = cart;
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meal_item, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        String meal = mealList.get(position);
        holder.mealNameTextView.setText(meal);

        // Add meal to cart when clicked
        holder.itemView.setOnClickListener(v -> {
            if (!cart.contains(meal)) {
                cart.add(meal);
                holder.mealNameTextView.setText(meal + " (Added)");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView mealNameTextView;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            mealNameTextView = itemView.findViewById(R.id.mealNameTextView);
        }
    }
}
