package com.example.pri.molomartnew.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.pri.molomartnew.R;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 21/09/2016.
 */
public class Adapter_Top_Services extends RecyclerView.Adapter<View_Holder_Top_Services> {
    List<Data_Top_Services> list = Collections.emptyList();
    Context context;

    public Adapter_Top_Services(List<Data_Top_Services> list, Context context){
        this.list = list;
        this.context = context;
    }
    @Override
    public View_Holder_Top_Services onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_services, parent, false);
        View_Holder_Top_Services holder = new View_Holder_Top_Services(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder_Top_Services holder, int position) {

        holder.name.setText(list.get(position).name);

    }

    @Override
    public int getItemCount() {

        return list.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data_Top_Services data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data_Top_Services data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}
