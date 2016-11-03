package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 16/09/2016.
 */

import android.content.Context;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pri.molomartnew.Fragments.FragmentCategory_List;
import com.example.pri.molomartnew.R;


import java.util.List;

public class Adapter_Dashboard extends RecyclerView.Adapter<Adapter_Dashboard.MyViewHolder> {

    private Context mContext;
    private List<Data_dashboard> albumList;
    FragmentTransaction mFragmentTransaction;
    FragmentManager mFragmentManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }


    public Adapter_Dashboard(Context mContext, List<Data_dashboard> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_dashboard_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Data_dashboard album = albumList.get(position);
        holder.title.setText(album.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCategory_List fragmentList=new FragmentCategory_List();
               // mFragmentManager =((Activity)mContext).getFragmentManager();
              mFragmentManager=  ((AppCompatActivity)mContext).getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame,fragmentList, "list").addToBackStack("List").commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}