package com.example.fruitvegetable;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Vegetable_Adapter extends RecyclerView.Adapter<Vegetable_Adapter.ViewHolder>
{

    Vegetable_Model vegetable_model;
    ArrayList<Vegetable_Model> Vegetable_List;
    Activity activity;

    Vegetable_Adapter(Vegetable_Model vegetable_model , ArrayList<Vegetable_Model> ArraylistVegetable , Activity activity)
    {
        this.Vegetable_List = ArraylistVegetable;
        this.vegetable_model = vegetable_model;
        this.activity = activity;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        String txtName = Vegetable_List.get(position).VegetableName;
        int image = Vegetable_List.get(position).Image;

        holder.ivImage.setImageResource(Vegetable_List.get(position).Image);
        holder.txtVName.setText(Vegetable_List.get(position).VegetableName);

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(activity , MainActivity4.class);
                intent.putExtra("img" , image);
                intent.putExtra("name" , txtName);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return Vegetable_List.size();
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
