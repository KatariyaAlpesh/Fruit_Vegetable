package com.example.fruitvegetable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class Fruite_Adapter extends RecyclerView.Adapter<Fruite_Adapter.viewHolder>
{

    Fruit_Activity fruit_activity ;
    ArrayList<String> fruitArrayList ;
    TextToSpeech textToSpeech;

    public Fruite_Adapter(Fruit_Activity fruit_activity, ArrayList<String> fruitArrayList)
    {
        this.fruit_activity = fruit_activity;
        this.fruitArrayList = fruitArrayList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_list_page , parent , false);
        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position)
    {

 //////////////==-->>>   Get Text and Speak to tuch on any Fruit name   <<<--===////////////////////////////
        textToSpeech = new TextToSpeech(fruit_activity.getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i)
            {
                if (i != TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });

  ////////////==-->>>>   Set ClickListener For ItemClick    <<<<--====/////////////////////////////////

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(fruit_activity, MainActivity3.class);
                intent.putExtra("img", position);
                intent.putExtra("name", fruitArrayList);
                fruit_activity.startActivity(intent);

                //////////////==-->>>   Get Text and Speak to tuch on any Fruit name   <<<--===////////////////////////////

                textToSpeech.speak(holder.txtFName.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);

            }
        });

 /////////////==-->>>   Get Image From Assets   <<<--=////////////////////////////////////////

        InputStream inputStream ;

        try
        {
            inputStream = fruit_activity.getAssets().open("fruits/" + fruitArrayList.get(position));
            Drawable drawable = Drawable.createFromStream(inputStream , null);

            holder.Image.setImageDrawable(drawable);
            holder.txtFName.setText(Config.fruitsPositionArray[position]);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getItemCount()
    {
        return fruitArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView txtFName;
        ImageView Image;
        CardView cardViewFruit;

        public viewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtFName = itemView.findViewById(R.id.Fruites);
            Image = itemView.findViewById(R.id.Fruite_Logo);
            cardViewFruit = itemView.findViewById(R.id.cardView_Fruit);

        }
    }

}
