package com.example.pri.molomartnew.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pri.molomartnew.Fragments.Fragment_Certicate_Package;
import com.example.pri.molomartnew.Fragments.Fragment_subscribe;
import com.example.pri.molomartnew.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by User on 20/09/2016.
 */
public class ListUrBusiness_recycle_adapter extends RecyclerView.Adapter<View_Holder_ListUrBusiness> {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    List<ListUrBusinessData> list= Collections.emptyList();
    Context context;

    public ListUrBusiness_recycle_adapter(List<ListUrBusinessData>list,Context context){
        this.list=list;
        this.context=context;
    }
    @Override
    public View_Holder_ListUrBusiness onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listurbusiness_cards_layout, parent, false);
        View_Holder_ListUrBusiness holder = new View_Holder_ListUrBusiness(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder_ListUrBusiness holder, int position) {
        ListUrBusinessData data = list.get(position);

        holder.name.setText(data.getName());
        holder.list.setText(data.getList());
        holder.price.setText(data.getPrice());
        holder.limit.setText(data.getLimit());
        holder.rs.setText(data.getRs());
        holder.subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_subscribe fragment_subscribe = new Fragment_subscribe();
                mFragmentManager =( (AppCompatActivity)context).getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragment_subscribe, "subscribe").addToBackStack("subscribe").commit();
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
    public void insert(int position, ListUrBusinessData data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(ListUrBusinessData data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}

