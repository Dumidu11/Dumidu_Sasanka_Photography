package com.example.dumidusasankaphotography;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

private ArrayList<usersaved> userArrayListFull;
  ArrayList<usersaved> userArrayList;
  private RecyclerViewClickListener listener;

    public MyAdapter(Context applicationContext, ArrayList<usersaved> userArrayList) {
        this.userArrayList = userArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.Name2.setText(userArrayList.get(position).getName11());
        holder.Event.setText(userArrayList.get(position).getEvent11());
        holder.Email.setText(userArrayList.get(position).getEmail11());
        holder.Teleno.setText(userArrayList.get(position).getTeleno11());
        holder.Time.setText(userArrayList.get(position).getTime11());
        holder.Vanue.setText(userArrayList.get(position).getVanue11());
        holder.Date.setText(userArrayList.get(position).getDate11());
        holder.Crew.setText(userArrayList.get(position).getCrew11());
        holder.Photoname.setText(userArrayList.get(position).getPhotographer_name());


        holder.itemView.setOnClickListener(view -> {
            listener.onClick(userArrayList.get(position));
        });




    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public interface RecyclerViewClickListener{
        void  onClick(View v,int position);

        void onClick(usersaved usersaved);
    }

  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


      TextView Name2,Email,Teleno,Event,Date,Time,Vanue,Crew,Photoname,Note;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name2 = itemView.findViewById(R.id.n1);
             Email = itemView.findViewById(R.id.e1);
            Teleno = itemView.findViewById(R.id.t1);
            Event = itemView.findViewById(R.id.ev1);
            Date = itemView.findViewById(R.id.d1);
            Time = itemView.findViewById(R.id.ti1);
            Vanue = itemView.findViewById(R.id.v1);
            Crew= itemView.findViewById(R.id.c1);
            Photoname=itemView.findViewById(R.id.ph1);
            Note=itemView.findViewById(R.id.not1);

            itemView.setOnClickListener(this);
        }

      @Override
      public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());

      }
  }


}
