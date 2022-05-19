package com.application.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.application.fooddelivery.Apapters.OrderAdapters;
import com.application.fooddelivery.Modelss.OrdersModel;
import com.application.fooddelivery.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhalper dBhalper=new DBhalper(this);
        ArrayList<OrdersModel> list = dBhalper.getOrders();

        //list.add(new OrdersModel());

        OrderAdapters adapters = new OrderAdapters(list, this);
        binding.orderRecyclerView.setAdapter(adapters);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(linearLayoutManager);
    }

}