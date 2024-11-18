package com.example.mealplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mealRecyclerView;
    private TextView cartItemsTextView;
    private Button showCartButton;

    private MealAdapter mealAdapter;
    private List<String> mealList;
    private List<String> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        mealRecyclerView = findViewById(R.id.mealRecyclerView);
        cartItemsTextView = findViewById(R.id.cartItemsTextView);
        showCartButton = findViewById(R.id.showCartButton);

        // Initialize meal list
        mealList = new ArrayList<>();
        mealList.add("Spaghetti Bolognese");
        mealList.add("Grilled Chicken Salad");
        mealList.add("Vegetable Stir Fry");
        mealList.add("Tacos");
        mealList.add("Vegetarian Curry");
        mealList.add("BBQ Ribs");

        // Initialize cart
        cart = new ArrayList<>();

        // Set up RecyclerView
        mealAdapter = new MealAdapter(mealList, cart);
        mealRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mealRecyclerView.setAdapter(mealAdapter);

        // Show cart items when the button is clicked
        showCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCartItems();
            }
        });
    }

    private void displayCartItems() {
        if (cart.isEmpty()) {
            cartItemsTextView.setText("Your cart is empty.");
        } else {
            StringBuilder cartItems = new StringBuilder("Selected Items:\n");
            for (String item : cart) {
                cartItems.append("- ").append(item).append("\n");
            }
            cartItemsTextView.setText(cartItems.toString());
        }
    }
}
