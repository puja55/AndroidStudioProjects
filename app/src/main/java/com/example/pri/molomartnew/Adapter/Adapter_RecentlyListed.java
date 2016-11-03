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
public class Adapter_RecentlyListed extends RecyclerView.Adapter<Adapter_RecentlyListed.View_Holder_Business> {
    public static final int REQUEST_CALL =1 ;
    Context mContext;
    FragmentTransaction mFragmentTransaction;
    FragmentManager mFragmentManager;
    Intent intent;

    List<Data_RecentlyListed> list;
    int lastPosition = -1;
    public class View_Holder_Business extends RecyclerView.ViewHolder {

        CardView cv;

        TextView title;
        TextView link;
        TextView category;
        TextView location;
        TextView phno;
        TextView description;
        ImageView imageView;
        public LinearLayout ll_phone;

        View_Holder_Business(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
            link = (TextView) itemView.findViewById(R.id.link);
            category = (TextView) itemView.findViewById(R.id.architecture);
            location = (TextView) itemView.findViewById(R.id.location);
            ll_phone = (LinearLayout) itemView.findViewById(R.id.li_phn);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }
    }

    public Adapter_RecentlyListed(List<Data_RecentlyListed> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public View_Holder_Business onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag_recentlylisted_row, parent, false);

        return new View_Holder_Business(v);

    }



    @Override
    public void onBindViewHolder(final View_Holder_Business holder, final int position) {
        Data_RecentlyListed data = list.get(position);
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

        holder.link.setText(data.getLink());
        holder.category.setText(data.getCategory());
        holder.location.setText(data.getLocation());
      //  holder.phno.setText(data.getPhno());
        holder.description.setText(data.getDescription());
        holder.imageView.setImageResource(data.getImageId());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Frgment_Map frgment_map = new Frgment_Map();
                mFragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, frgment_map, "map").addToBackStack("Map").commit();

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
    public void insert(int position, Data_RecentlyListed dataB) {
        list.add(position, dataB);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data_RecentlyListed dataB) {
        int position = list.indexOf(dataB);
        list.remove(position);
        notifyItemRemoved(position);
    }

}