package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Fruit_Activity extends AppCompatActivity
{

    ArrayList<String> fruitArrayList;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        recyclerView = findViewById(R.id.activityFruits);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try
        {
            String[] fruitsPositionArray = getAssets().list("fruits");
            fruitArrayList = new ArrayList<>(Arrays.asList(fruitsPositionArray));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        Fruite_Adapter adapter = new Fruite_Adapter(this , fruitArrayList);
        recyclerView.setAdapter(adapter);

        }

}