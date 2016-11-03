package com.example.pri.molomartnew.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pri.molomartnew.Adapter.Data_Top_Business;
import com.example.pri.molomartnew.Adapter.Adapter_Top_Business;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/09/2016.
 */
public class Fragment_TopBusiness extends Fragment {
    Context mcontext;
    public Fragment_TopBusiness(){}
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.frag_category_list,container,false);
        List<Data_Top_Business> data=fill_with_data();
        RecyclerView recyclerView=(RecyclerView)rootview.findViewById(R.id.recyclerview);
        Adapter_Top_Business adapter=new Adapter_Top_Business(data,getActivity())
                ;
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setNestedScrollingEnabled(false);
        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).showFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Top Business");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        return rootview;
    }

    private List<Data_Top_Business> fill_with_data(){
        List<Data_Top_Business>data =new ArrayList<>();
        data.add(new Data_Top_Business("Online Taxi Booking Service","Jaipur",R.drawable.listimg1));
        data.add(new Data_Top_Business("Super Specialty Homeopathic Hospital","Indore",R.drawable.listimg3));
        data.add(new Data_Top_Business("Shree Manmohan Sugandh Bhandar","Indore",R.drawable.listimg4));
        data.add(new Data_Top_Business("Online Taxi Booking Service","Jaipur",R.drawable.listimg2));
        data.add(new Data_Top_Business("Online Taxi Booking Service","Jaipur",R.drawable.listimg5));
        return data;


    }

    public class DividerItemDecoration extends RecyclerView.ItemDecoration {

        private  final int[] ATTRS = new int[]{android.R.attr.listDivider};

        private Drawable mDivider;

        /**
         * Custom divider will be used
         */
        public DividerItemDecoration(Context context, int resId) {
            mDivider = ContextCompat.getDrawable(context, resId);
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}
