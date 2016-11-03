package com.example.pri.molomartnew.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

/**
 * Created by Pri on 10/11/2016.
 */
public class FragmentImgZoom extends Fragment {

    public void FragmentImgZoom(){


    }
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_img_zoom,container,false);

        ImageView img=(ImageView)v.findViewById(R.id.img_zoom);
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }

        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(" ");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        return  v;
    }
}
