package com.example.pri.molomartnew.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;


public class FragmentAboutUs extends Fragment implements View.OnClickListener {
    Toolbar toolbar;
    ImageView fb,twitter,google,linked,pinterest;
    public FragmentAboutUs() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_aboutus, container, false);
fb=(ImageView)rootView.findViewById(R.id.fb);
        twitter=(ImageView)rootView.findViewById(R.id.twitter);
        google=(ImageView)rootView.findViewById(R.id.google);
        linked=(ImageView)rootView.findViewById(R.id.linked);
        pinterest=(ImageView)rootView.findViewById(R.id.pintras);

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }

        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("About Us");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        fb.setOnClickListener(this);
        twitter.setOnClickListener(this);
        google.setOnClickListener(this);
        linked.setOnClickListener(this);
        pinterest.setOnClickListener(this);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.fb:
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "https://www.facebook.com/molomartindia/"));
        startActivity(browserIntent);
                break;


            case R.id.twitter:
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://twitter.com/"));
                startActivity(browserIntent1);
                break;

            case R.id.google:
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://www.molomart.com/#"));
                startActivity(browserIntent2);
                break;

            case R.id.linked:
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://www.molomart.com/#"));
                startActivity(browserIntent3);
                break;

            case R.id.pintras:
                Intent browserIntent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://www.molomart.com/#"));
                startActivity(browserIntent4);
                break;
            default:
                break;
        }
    }
    }
