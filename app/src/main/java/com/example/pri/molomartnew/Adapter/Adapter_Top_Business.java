package com.example.pri.molomartnew.Adapter;

import android.content.Context;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pri.molomartnew.Fragments.Frgment_Map;
import com.example.pri.molomartnew.R;


import java.util.List;

public class Adapter_Top_Business extends RecyclerView.Adapter<Adapter_Top_Business.View_Holder_Recently> {

    Context mContext;
    FragmentTransaction mFragmentTransaction;
    FragmentManager mFragmentManager;
    List<Data_Top_Business> list;

    public class View_Holder_Recently extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView title;
        public TextView city;

        public ImageView imageView;

        View_Holder_Recently(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.recentlycardView);
            title = (TextView) itemView.findViewById(R.id.recentlytitle);
            city=(TextView)itemView.findViewById(R.id.recentlycity);

            imageView = (ImageView) itemView.findViewById(R.id.recentlyimageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }


    public Adapter_Top_Business(List<Data_Top_Business> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public View_Holder_Recently onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_topbusiness_row, parent, false);

        return new View_Holder_Recently(itemView);
    }


    @Override
    public void onBindViewHolder(final View_Holder_Recently holder, int position) {
        Data_Top_Business data = list.get(position);
        holder.title.setText(data.getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frgment_Map frgment_map = new Frgment_Map();
                mFragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, frgment_map, "map").addToBackStack("Map").commit();

            }
        });
        holder.city.setText(data.getCity());
        holder.imageView.setImageResource(data.getImageId());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frgment_Map frgment_map=new Frgment_Map();
                mFragmentManager = ((AppCompatActivity)mContext).getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame,frgment_map, "map").addToBackStack("Map").commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data_Top_Business data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data_Top_Business data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}