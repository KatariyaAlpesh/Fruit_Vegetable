package com.example.fruitvegetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Level_Page extends AppCompatActivity implements View.OnClickListener
{

    CardView FRUITE,VEGETABLE;
    Animation FruiteAnimation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_page);

        FRUITE = findViewById(R.id.FRUITE);
        VEGETABLE = findViewById(R.id.VEGETABLE);
        FruiteAnimation = AnimationUtils.loadAnimation(this , R.anim.fruite);

        FRUITE.setOnClickListener(this);
        VEGETABLE.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {

        if (view.getId() == FRUITE.getId())
        {

            view.startAnimation(FruiteAnimation);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    Intent INext;
                    INext = new Intent(Level_Page.this , Fruit_Activity.class);
                    startActivity(INext);
                }
            }, 500);

        }
        if (view.getId() == VEGETABLE.getId())
        {
            Intent INext;
            INext = new Intent(Level_Page.this , Vegetable_Activity.class);
            startActivity(INext);
        }
    }
}