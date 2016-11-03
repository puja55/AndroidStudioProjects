package com.example.pri.molomartnew.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * Created by User on 12/10/2016.
 */
public class Fragment_subscribe extends Fragment implements View.OnClickListener {
   public  Fragment_subscribe(){

    }
    FragmentTransaction mFragmentTransaction;
    FragmentManager mFragmentManager;
    TextView change_package;
Button upload_img;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
this.setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_subscrbe, container, false);

        change_package=(TextView)view.findViewById(R.id.chage_pkg);
upload_img=(Button)view.findViewById(R.id.btn_uploadimg);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.country_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                view.findViewById(R.id.subscribe_country);
        materialDesignSpinner.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.state_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner1 = (MaterialBetterSpinner)
                view.findViewById(R.id.subscribe_state);
        materialDesignSpinner1.setAdapter(adapter1);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.city_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner)
                view.findViewById(R.id.subscribe_city);
        materialDesignSpinner2.setAdapter(adapter2);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.village_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner3 = (MaterialBetterSpinner)
                view.findViewById(R.id.subscribe_village);
        materialDesignSpinner3.setAdapter(adapter3);


        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.category_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner4 = (MaterialBetterSpinner)
                view.findViewById(R.id.subscribe_category);
        materialDesignSpinner4.setAdapter(adapter4);

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Subscribe");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

change_package.setOnClickListener(this);
        upload_img.setOnClickListener(this);
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_send, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_search).setVisible(false);
        menu.findItem(R.id.right).setVisible(false);
//        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
//        menu.findItem(R.id.about_app).setVisible(!drawerOpen);
//        menu.findItem(R.id.refresh).setVisible(!drawerOpen);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chage_pkg:
                ListUrBusiness listUrBusiness = new ListUrBusiness();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, listUrBusiness, "listurbusiness").addToBackStack("listurbusiness").commit();
                break;

            case R.id.btn_uploadimg:
                opengallery();
                break;

            default:
                break;
        }
    }

        public void opengallery(){

    }


    }

