package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity
{

    ArrayList<Vegetable_Model> Vegetable_List = new ArrayList<>();

    Vegetable_Model vegetable_model;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView Activitymain2 = findViewById(R.id.activitymain2);

        Activitymain2.setLayoutManager(new LinearLayoutManager(this));

        Vegetable_List.add(new Vegetable_Model(R.drawable.cabbage , "Cabbage"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.capsicum , "Capsicum"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.carrot , "Carrot"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.cauliflower3 , "Cauliflower"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.corn , "Corn"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.eggplant , "Eggplant"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.onion , "Onion"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.pea , "Pea"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.pear1 , "Pear"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.potato , "Potato"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.pumpkin , "Pumpkin"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.tomato , "Tomato"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.black_brinjal , "Black_Brinjal"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.broccoli , "Broccoli"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.chayote , "Chayote"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.cucumber , "Cucumber"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.galangal , "Galangal"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.green_pepper , "Green_Pepper"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.green_pepper1 , "Green_Pepper"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.green_png , "Green_Salad"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.green_salad , "Salad"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.kohlrabi , "Kohlarbi"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.lemon1 , "Lemon"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.mushroom , "Mushroom"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.red_chili_pepper , "Red_Chilli"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.red_onion , "Red_Onion"));
        Vegetable_List.add(new Vegetable_Model(R.drawable.salad_leaf , "Salad_Leaf"));



        Vegetable_Adapter vegetable_adapter = new Vegetable_Adapter(vegetable_model , Vegetable_List,this);
        Activitymain2.setAdapter(vegetable_adapter);
    }
}