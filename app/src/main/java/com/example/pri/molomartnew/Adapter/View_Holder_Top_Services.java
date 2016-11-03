package com.example.pri.molomartnew.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pri.molomartnew.R;


/**
 * Created by User on 21/09/2016.
 */
public class View_Holder_Top_Services extends RecyclerView.ViewHolder {

    public CardView cv;
    public TextView name;


    View_Holder_Top_Services(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        name = (TextView) itemView.findViewById(R.id.tservicesname);

    }
}