package com.example.fruitvegetable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fruite_Adapter extends RecyclerView.Adapter<Fruite_Adapter.viewHolder>
{

    Fruite_Model fruite_model;
    ArrayList<Fruite_Model> Fruit_List;
    Activity mActivity;

    Fruite_Adapter(Fruite_Model fruite_model , ArrayList<Fruite_Model> ArraylistFruit, Activity activity)
    {
        this.fruite_model = fruite_model;
        this.Fruit_List = ArraylistFruit;
        this.mActivity=activity;
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
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        String txtname=Fruit_List.get(position).FruitName;
        int image=Fruit_List.get(position).Image;

         holder.Image.setImageResource(image);
         holder.txtFName.setText(txtname);

         holder.itemView.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View view)
             {
                 Intent intent=new Intent(mActivity, MainActivity3.class);
                 intent.putExtra("img", image);
                 intent.putExtra("name", txtname);
                 mActivity.startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount()
    {
        return Fruit_List.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView txtFName;
        ImageView Image;
        public viewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtFName = itemView.findViewById(R.id.Fruites);
            Image = itemView.findViewById(R.id.Fruite_Logo);

        }
    }

}
