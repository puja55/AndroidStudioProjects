package com.example.pri.molomartnew.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pri.molomartnew.Adapter.Data;
import com.example.pri.molomartnew.Adapter.Adapter_Category_List;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by Pri on 9/17/2016.
 */
public class FragmentCategory_List extends Fragment {

    public static final int REQUEST_CALL =1 ;
    Context context;
    Toolbar toolbar;

    public FragmentCategory_List(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.frag_category_list, container, false);


        //toolbar.setLogo(R.drawable.filtr);

        // getActivity().onBackPressed();
        setHasOptionsMenu(true);
        List<Data> data = fill_with_data();

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerview);
        Adapter_Category_List adapter = new Adapter_Category_List(data, context);

      //  recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        //or
        recyclerView.addItemDecoration(
                new DividerItemDecoration(getActivity(), R.drawable.divider));

        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).showFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Molo Mart");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        if (checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                    REQUEST_CALL);
        }

        return rootView;

    }

    private List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();

        data.add(new Data("Chir Variation Boutique"," Boutique"," Indore"," 6823762317210","Chir Variation Boutique a garment boutique all type ladies garment , western ,indo-western,lahnga,blouse,salwar kamiz are available in one Boutique ", R.drawable.listimg1));
        data.add(new Data("Kasturi collection and Boutique"," Boutique"," Indore"," 682376231", "Dress material Salvar suit and saree ", R.drawable.listimg2));
        data.add(new Data("Shravani- saree & Dress material"," Boutique"," Indore"," 6823762310", "Various types of saree and Dress material are available at our shop. ", R.drawable.listimg3));
        data.add(new Data("shri hari telars", " architecture"," Indore"," 682317210","We hew taelars", R.drawable.listimg4));
        data.add(new Data("Shravani- saree & Dress material", " Boutique"," Indore"," 682317210","Various types of saree and Dress material are available at our shop. ", R.drawable.listimg5));
        data.add(new Data("Kasturi collection and Boutique"," architecture"," Indore"," 6827210", "Dress material Salvar suit and saree ", R.drawable.listimg6));

        return data;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CALL:
            {
                if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                   // startActivity(callIntent);
                }else{
                    ////
                }
            }
        }
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
