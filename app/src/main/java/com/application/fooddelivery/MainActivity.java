package com.application.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.application.fooddelivery.Apapters.MainAdapters;
import com.application.fooddelivery.Modelss.MainModel;
import com.application.fooddelivery.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Arrays of food
        ArrayList<MainModel> list= new ArrayList<>();
        list.add(new MainModel(R.drawable.food1, "Combo Items", "6", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(R.drawable.food2, "Burger", "3", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(R.drawable.food3, "Cheese", "6", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(R.drawable.food4, "Hot Dog", "4", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(R.drawable.food5, "Combo Mockup", "3", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));
        list.add(new MainModel(R.drawable.food1, "Combo Items", "6", "A combination meal, often referred as a combo-meal, is a type of meal that typically includes food items and a beverage. They are a common menu item at fast food restaurants, and other restaurants also purvey them."));

        MainAdapters adapters = new MainAdapters(list, this);
        binding.recylerView.setAdapter(adapters);

       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       binding.recylerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carticon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orderIcon:
                startActivity(new Intent(MainActivity.this, OrdersActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}