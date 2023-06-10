package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Fruite_Model> Fruit_List = new ArrayList<>();
    Fruite_Model fruite_model;
    CardView FL;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FL = findViewById(R.id.FL);

        RecyclerView ActivityMain = findViewById(R.id.activitymain);

        ActivityMain.setLayoutManager(new LinearLayoutManager(this));

        Fruit_List.add(new Fruite_Model(R.drawable.apple1 , "Apple"));
        Fruit_List.add(new Fruite_Model(R.drawable.banana1 , "Banana"));
        Fruit_List.add(new Fruite_Model(R.drawable.blueberry , "Bluebary"));
        Fruit_List.add(new Fruite_Model(R.drawable.dragon_fruit , "Dragon_fruit"));
        Fruit_List.add(new Fruite_Model(R.drawable.grape1 , "Grapes"));
        Fruit_List.add(new Fruite_Model(R.drawable.kiwi1 , "Kivi"));
        Fruit_List.add(new Fruite_Model(R.drawable.mango1 , "Mango"));
        Fruit_List.add(new Fruite_Model(R.drawable.orange1 , "Orange"));
        Fruit_List.add(new Fruite_Model(R.drawable.pineapple1 , "Pineapple"));
        Fruit_List.add(new Fruite_Model(R.drawable.strawberry1 , "Strawberry"));
        Fruit_List.add(new Fruite_Model(R.drawable.red_cherry1 , "Red_Cherry"));
        Fruit_List.add(new Fruite_Model(R.drawable.green_apples1 , "Grean_Apple"));
        Fruit_List.add(new Fruite_Model(R.drawable.grean_pear1 , "Grean_Pear"));
        Fruit_List.add(new Fruite_Model(R.drawable.pear1 , "Pear"));
        Fruit_List.add(new Fruite_Model(R.drawable.peach1 , "Peach"));
        Fruit_List.add(new Fruite_Model(R.drawable.avocado1 , "Avocado"));
        Fruit_List.add(new Fruite_Model(R.drawable.guava1 , "Guava"));
        Fruit_List.add(new Fruite_Model(R.drawable.grape11 , "Green_Grapes"));
        Fruit_List.add(new Fruite_Model(R.drawable.jamun1 , "Jamun"));
        Fruit_List.add(new Fruite_Model(R.drawable.plum1 , "Plum"));
        Fruit_List.add(new Fruite_Model(R.drawable.pomegranat1 , "Pomegranat"));
        Fruit_List.add(new Fruite_Model(R.drawable.watermelon1 , "Watermelon"));


        Fruite_Adapter adapter = new Fruite_Adapter(fruite_model , Fruit_List, this);
        ActivityMain.setAdapter(adapter);

        }
}