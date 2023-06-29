package com.example.fruitvegetable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity
{
    TextView textViewShow;
    ImageView imageViewShow;
    TextToSpeech textToSpeech;
    int clickedImagePossition;
    ArrayList<String> fruitArrayList = new ArrayList<>();
    ImageView home , previousFruit , pencil , nextFruit , shareApp;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_final);

        textViewShow = findViewById(R.id.Fruites2);
        imageViewShow = findViewById(R.id.Fruite_Logo2);
        home = findViewById(R.id.gotoHome);
        previousFruit = findViewById(R.id.previousFruit);
        pencil = findViewById(R.id.fruitPencil);
        nextFruit = findViewById(R.id.nextFruit);
        shareApp = findViewById(R.id.shareFruitApp);

        clickedImagePossition = getIntent().getIntExtra("img" , 0);
        fruitArrayList = getIntent().getStringArrayListExtra("name");

        InputStream inputStream;

        try
        {
            inputStream =getAssets().open("fruits/" + fruitArrayList.get(clickedImagePossition));
            Drawable drawable = Drawable.createFromStream(inputStream , null);

            imageViewShow.setImageDrawable(drawable);
            textViewShow.setText(Config.fruitsPositionArray[clickedImagePossition]);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }


 ///////////////===-->>>    Click On Home and Go To List Page   <<<<--=====/////////////////

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent;
                intent = new Intent(MainActivity3.this , Fruit_Activity.class);
                startActivity(intent);
                finish();
            }
        });


        /////==-->>   Code For The Speak   <<<--===/////////
        textToSpeech = new TextToSpeech(MainActivity3.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i)
            {
                if (i != TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

////////////========>>>>>>>>    Go to PreviousFruit On Click  { previousFruit }   <<<==////////////////////////////////

        previousFruit.setOnClickListener(v -> {


            if( clickedImagePossition > 0 )
            {
                clickedImagePossition--;   ///    Doing -- For Going Back

                InputStream inputStream2;

                try
                {
                    inputStream2 = getAssets().open("fruits/" + fruitArrayList.get(clickedImagePossition));
                    Drawable drawable = Drawable.createFromStream(inputStream2 , null);

                    imageViewShow.setImageDrawable(drawable);
                    textViewShow.setText(Config.fruitsPositionArray[clickedImagePossition]);

                    /////==-->>   Code For The Speak   <<<--===/////////
                    textToSpeech.speak(textViewShow.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);

                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }

//                String URL = fruitArrayList.get(clickedImagePossition);
//                Glide.with(MainActivity3.this).load(URL).into(imageViewShow);

                textViewShow.setText(Config.fruitsPositionArray[clickedImagePossition]);

            }

        });

 ////////////========>>>>>>>>    Go to NextFruit On Click  { NextFruit }   <<<==////////////////////////////////

        nextFruit.setOnClickListener(v -> {

            if( clickedImagePossition < fruitArrayList.size() - 1 )
            {
                clickedImagePossition++;   ///    Doing ++ For Going Next Fruit


                InputStream inputStream1;

                try
                {
                    inputStream1 = getAssets().open("fruits/" + fruitArrayList.get(clickedImagePossition));
                    Drawable drawable = Drawable.createFromStream(inputStream1 , null);

                    imageViewShow.setImageDrawable(drawable);
                    textViewShow.setText(Config.fruitsPositionArray[clickedImagePossition]);

                    /////==-->>   Code For The Speak   <<<--===/////////

                    textToSpeech.speak(textViewShow.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);

                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }

//                String URL = fruitArrayList.get(clickedImagePossition);
//                Glide.with(MainActivity3.this).load(URL).into(imageViewShow);

                textViewShow.setText(Config.fruitsPositionArray[clickedImagePossition]);

            }

        });

 /////////////////==--->>>>     Share The Appp   <<<<<--====//////////////////////////////////////////////

        shareApp.setOnClickListener(view -> {

            Intent intent;
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String shareBody = "\n/*Shared by Alpesh */ ";
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

            startActivity(intent);
        });

    }
}