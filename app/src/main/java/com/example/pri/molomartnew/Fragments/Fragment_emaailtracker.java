package com.example.pri.molomartnew.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

/**
 * Created by User on 13/10/2016.
 */
public class Fragment_emaailtracker extends Fragment implements View.OnClickListener {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public Fragment_emaailtracker(){

    }Toolbar toolbar;
    AppCompatButton email_bulkemail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.email_tracker, container, false);
        email_bulkemail=(AppCompatButton)view.findViewById(R.id.email_bulkemail);

        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Email Tracker");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }
        email_bulkemail.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Fragment_bulkemail fragment_bulkemail = new Fragment_bulkemail();
        mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame, fragment_bulkemail, "recently").addToBackStack("recently").commit();
    }
}
