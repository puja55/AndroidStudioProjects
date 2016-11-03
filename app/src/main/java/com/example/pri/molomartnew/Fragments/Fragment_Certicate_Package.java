package com.example.pri.molomartnew.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * Created by User on 29/09/2016.
 */
public class Fragment_Certicate_Package extends Fragment
{
    Toolbar toolbar;
    Context mcontext;
    public Fragment_Certicate_Package(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_img_gallery,container,false);
        List<ListUrBusinessData> data=fill_with_data();
        RecyclerView recyclerView=(RecyclerView)rootview.findViewById(R.id.businessrecyclerview);
        ListUrBusiness_recycle_adapter adapter=new ListUrBusiness_recycle_adapter(data,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setFocusable(false);
        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Certificate Package");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        return rootview;
    }

    private List<ListUrBusinessData> fill_with_data(){
        List<ListUrBusinessData>data =new ArrayList<>();
        data.add(new ListUrBusinessData("Blue","Featured Listing with Certification of Rating, Business Promotion Training , CRM Software (One Year) ","INR 25,000","365 Days","25,000"));
        data.add(new ListUrBusinessData("Indigo","Front page Featured Listing, Personalized Training, Certificate of Rating, Stock Management System, CRM","INR 50,000","365 Days","50,000"));
        data.add(new ListUrBusinessData("Violet","Front Page Advertisement Banner, Front page featured listing, Dynamic Website, Customized SEO, Personalized Training, Certificate Of Rating, Stock Management System, CRM, Online Promotion ","INR 100,000","365 Days","100,000"));

        return data;


    }
}
