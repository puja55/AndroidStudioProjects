package com.example.pri.molomartnew.Fragments;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02/10/2016.
 */
public class Fragmen_help extends Fragment implements View.OnClickListener {
    TextView contact,about,terms,privacy;
    FragmentManager mFragmentManager;
    Context mContext;
    FragmentTransaction mFragmentTransaction;
    public Fragmen_help() {

    }
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_help, container, false);
        contact=(TextView)rootView.findViewById(R.id.helpncontact);
        about=(TextView)rootView.findViewById(R.id.aboutapp);
        terms=(TextView)rootView.findViewById(R.id.termsncondt);
        privacy=(TextView)rootView.findViewById(R.id.privacypolicy);
        contact.setOnClickListener(this);
        about.setOnClickListener(this);
        terms.setOnClickListener(this);
        privacy.setOnClickListener(this);
        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).showFloatingActionMenu();
        }

        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Help");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.helpncontact:
                FragmentContactUs fragmentContactUs = new FragmentContactUs();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentContactUs, "contactus").addToBackStack("contactus").commit();
                break;
            case R.id.aboutapp:
                FragmentAboutUs fragmentAboutUs = new FragmentAboutUs();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentAboutUs, "aboutus").addToBackStack("aboutus").commit();
                break;
            case R.id.termsncondt:
                FragmentTrmCondition fragmentTrmCondition = new FragmentTrmCondition();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentTrmCondition, "trmCondition").addToBackStack("trmCondition").commit();
               break;
            case R.id.privacypolicy:
                FragmentPrivacyPolicy fragmentPrivacyPolicy = new FragmentPrivacyPolicy();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentPrivacyPolicy, "privacy").addToBackStack("privacy").commit();
                break;
        }

    }
}


