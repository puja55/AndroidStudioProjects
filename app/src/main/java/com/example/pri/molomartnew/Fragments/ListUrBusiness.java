package com.example.pri.molomartnew.Fragments;

/**
 * Created by User on 28/09/2016.
 */

import android.content.Context;
import android.content.res.TypedArray;
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

import com.example.pri.molomartnew.Adapter.ListUrBusinessData;
import com.example.pri.molomartnew.Adapter.ListUrBusiness_recycle_adapter;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20/09/2016.
 */
public class ListUrBusiness extends Fragment {
    Context mcontext;
    public ListUrBusiness(){}
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_img_gallery,container,false);
        List<ListUrBusinessData> data=fill_with_data();
        RecyclerView recyclerView=(RecyclerView)rootview.findViewById(R.id.businessrecyclerview);
        ListUrBusiness_recycle_adapter adapter=new ListUrBusiness_recycle_adapter(data,getActivity());
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }

        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Listing Packge");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));



        return rootview;
    }

    private List<ListUrBusinessData> fill_with_data(){
        List<ListUrBusinessData>data =new ArrayList<>();
        data.add(new ListUrBusinessData("Red","Listing for 6 months","INR 2,000","180 Days","2,000"));
        data.add(new ListUrBusinessData("Orange","Listing for one year","INR 3,500","365 Days","3,500"));
        data.add(new ListUrBusinessData("Free","Free for 30 days","INR 0","30 Days","0"));
        data.add(new ListUrBusinessData("Yellow","Featured Listing for one year","INR 5,000","365 Days","5,000"));
        data.add(new ListUrBusinessData("Green","Featured Listing with panel to manage listing, offers for one year","INR 10,000","365 Days","10,000"));
        return data;


    }

    public class DividerItemDecoration extends RecyclerView.ItemDecoration {

        private  final int[] ATTRS = new int[]{android.R.attr.listDivider};

        private Drawable mDivider;

        /**
         * Default divider will be used
         */
        public DividerItemDecoration(Context context) {
            final TypedArray styledAttributes = context.obtainStyledAttributes(ATTRS);
            mDivider = styledAttributes.getDrawable(0);
            styledAttributes.recycle();
        }

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
