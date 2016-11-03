package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 28/09/2016.
 */
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pri.molomartnew.R;

public class View_Holder_ListUrBusiness extends RecyclerView.ViewHolder {
    public CardView cv;
    public TextView name,list,price,limit;
    public Button rs,subscribe;


    View_Holder_ListUrBusiness(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.card_view);
        name = (TextView) itemView.findViewById(R.id.listName);
        list=(TextView)   itemView.findViewById(R.id.list);
        price = (TextView) itemView.findViewById(R.id.price1);
        limit = (TextView) itemView.findViewById(R.id.limit1);
        rs = (Button) itemView.findViewById(R.id.rs);
        subscribe=(Button)itemView.findViewById(R.id.subscribebtn);


    }
}

