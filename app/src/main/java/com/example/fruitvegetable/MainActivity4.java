package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity
{

    TextView txt1;
    ImageView img1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txt1 = findViewById(R.id.Vegetable2);
        img1 = findViewById(R.id.Vegetable_Logo2);

        Intent a = getIntent();
        int image = a.getIntExtra("img" , 0);
        String txtName = a.getStringExtra("name");

        txt1.setText(txtName);
        img1.setImageResource(image);
    }
}