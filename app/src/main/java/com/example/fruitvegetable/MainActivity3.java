package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity
{
    TextView txt1;
    ImageView img1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3 );

        txt1 = findViewById(R.id.Fruites2);
        img1 = findViewById(R.id.Fruite_Logo2);

       Intent b=getIntent();
       int image=b.getIntExtra("img",0);
       String txtName=b.getStringExtra("name");

       txt1.setText(txtName);
       img1.setImageResource(image);


    }
}