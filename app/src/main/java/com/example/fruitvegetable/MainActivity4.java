package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity
{

    TextView textViewShow;
    ImageView imageViewShow;

    int clickedImagePossition;
    ArrayList<String> vegetableArrayList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_final);

        textViewShow = findViewById(R.id.Vegetable2);
        imageViewShow = findViewById(R.id.Vegetable_Logo2);

        clickedImagePossition = getIntent().getIntExtra("img" , 0);
        vegetableArrayList = getIntent().getStringArrayListExtra("name");

        InputStream inputStream;

        try
        {
            inputStream = getAssets().open("vegetables/" + vegetableArrayList.get(clickedImagePossition));
            Drawable drawable = Drawable.createFromStream(inputStream , null);

            imageViewShow.setImageDrawable(drawable);
            textViewShow.setText(Config.vegetablePositionArray[clickedImagePossition]);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

}