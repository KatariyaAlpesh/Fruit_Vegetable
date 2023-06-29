package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Vegetable_Activity extends AppCompatActivity
{
    ArrayList<String> vegetableArrayList;
    RecyclerView recyclerView;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);

        recyclerView = findViewById(R.id.activityVegetable);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try
        {
            String[] vegetablePositionArray = getAssets().list("vegetables");
            vegetableArrayList = new ArrayList<>(Arrays.asList(vegetablePositionArray));

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }


        Vegetable_Adapter vegetable_adapter = new Vegetable_Adapter(this , vegetableArrayList);
        recyclerView.setAdapter(vegetable_adapter);

    }
}