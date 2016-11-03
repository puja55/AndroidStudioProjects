package com.example.pri.molomartnew.Adapter;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pri.molomartnew.Fragments.Frgment_Map;
import com.example.pri.molomartnew.R;
import java.util.List;

/**
 * Created by Pri on 9/17/2016.
 */
public class Adapter_Category_List extends RecyclerView.Adapter<Adapter_Category_List.View_Holder> {
    Context mContext;
    public static final int REQUEST_CALL =1 ;
    FragmentTransaction mFragmentTransaction;
    FragmentManager mFragmentManager;
    List<Data> list;
    Intent intent;

    public class View_Holder extends RecyclerView.ViewHolder {

        public CardView cv;
        public TextView title;
        public TextView category;
        public TextView location;
        public TextView phno;
        public TextView description;
        public ImageView imageView ,img;
        public LinearLayout ll_phone;

        public View_Holder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
            category=(TextView)itemView.findViewById(R.id.architecture);
            location=(TextView)itemView.findViewById(R.id.location);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            ll_phone = (LinearLayout) itemView.findViewById(R.id.ll_phone);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }

    public Adapter_Category_List(List<Data> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_row, parent, false);

        return new View_Holder(v);

    }

    @Override
    public void onBindViewHolder(final View_Holder holder, final int position) {
        Data data = list.get(position);
        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
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
        holder.category.setText(data.getCategory());
        holder.location.setText(data.getLocation());
        holder.description.setText(data.getDescription());
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


        holder.ll_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(((AppCompatActivity)mContext).getParent(), new String[]{Manifest.permission.CALL_PHONE}, 200);
                    }



                    String url = list.get(position).getPhno().toString().trim();

                    Toast.makeText(mContext,
                            ""+url, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + url));
                    ((Activity)mContext).startActivity(intent);
                }
                catch (android.content.ActivityNotFoundException ex) {
//                    Toast.makeText(mContext,
//                            "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
                }

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
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }



}