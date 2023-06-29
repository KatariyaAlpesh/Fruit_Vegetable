package com.example.fruitvegetable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

public class Vegetable_Adapter extends RecyclerView.Adapter<Vegetable_Adapter.ViewHolder>
{
    Vegetable_Activity vegetable_activity;
    ArrayList<String> vegetableArrayList;
    TextToSpeech textToSpeech;

    public Vegetable_Adapter(Vegetable_Activity vegetable_activity, ArrayList<String> vegetableArrayList)
    {
        this.vegetable_activity = vegetable_activity;
        this.vegetableArrayList = vegetableArrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vagetable_list , parent , false);
        Vegetable_Adapter.ViewHolder viewHolder = new Vegetable_Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position)
    {

 //////////////==-->>>   Get Text and Speak to tuch on any Fruit name   <<<--===////////////////////////////

        textToSpeech = new TextToSpeech(vegetable_activity.getApplicationContext(), new TextToSpeech.OnInitListener() {
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
                Intent intent=new Intent(vegetable_activity, MainActivity4.class);
                intent.putExtra("img", position);
                intent.putExtra("name", vegetableArrayList);
                vegetable_activity.startActivity(intent);

                //////////////==-->>>   Get Text and Speak to tuch on any Fruit name   <<<--===////////////////////////////

                textToSpeech.speak(holder.txtVName.getText().toString() , TextToSpeech.QUEUE_FLUSH , null);

            }
        });

        InputStream inputStream;

        try
        {
            inputStream = vegetable_activity.getAssets().open("vegetables/" + vegetableArrayList.get(position));
            Drawable drawable = Drawable.createFromStream(inputStream , null);

            holder.ivImage.setImageDrawable(drawable);
            holder.txtVName.setText(Config.vegetablePositionArray[position]);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getItemCount()
    {
        return vegetableArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtVName;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            ivImage = itemView.findViewById(R.id.Vegetable_Logo);
            txtVName = itemView.findViewById(R.id.Vegetable);
        }
    }
}
