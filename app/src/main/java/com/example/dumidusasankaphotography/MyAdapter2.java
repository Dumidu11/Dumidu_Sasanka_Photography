package com.example.dumidusasankaphotography;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    Context context;
    ArrayList<Productsmodel> productsmodelArrayList;

    public MyAdapter2(Context context, ArrayList<Productsmodel> productsmodelArrayList) {
        this.context = context;
        this.productsmodelArrayList = productsmodelArrayList;
    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  v = LayoutInflater.from(context).inflate(R.layout.list_item_single,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter2.MyViewHolder holder, int position) {



        holder.Name.setText(productsmodelArrayList.get(position).getName());
        holder.Event.setText(productsmodelArrayList.get(position).getEvent());
        holder.Booking.setText(productsmodelArrayList.get(position).getBooking());


    }

    @Override
    public int getItemCount() {
        return productsmodelArrayList.size();
    }
    public  static class  MyViewHolder extends  RecyclerView.ViewHolder{

        TextView  Name, Event, Booking;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.nn1);
            Event = itemView.findViewById(R.id.ee1);
            Booking = itemView.findViewById(R.id.bb1);
        }
    }
}
