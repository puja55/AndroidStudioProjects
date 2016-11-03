package com.example.pri.molomartnew.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

/**
 * Created by Pri on 10/4/2016.
 */
public class FragmentFilter extends Fragment implements View.OnClickListener {
    Toolbar toolbar;
    Context context;
    Button filtr;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public void FragmentFilter( ){


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_filter, container, false);

      ///  final CrystalSeekbar seekbar = new CrystalSeekbar(getActivity());
        final CrystalSeekbar rangeSeekbar = (CrystalSeekbar) view.findViewById(R.id.rangeSeekbar1);
       // rangeSeekbar.setPosition(CrystalSeekbar.Position.RIGHT).apply();
        final TextView tvMin = (TextView) view.findViewById(R.id.km_tv);

        rangeSeekbar.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue) {
                tvMin.setText(String.valueOf(minValue));
            }
        });

// set final value listener
        rangeSeekbar.setOnSeekbarFinalValueListener(new OnSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number value) {
                Log.d("CRS=>", String.valueOf(value));
            }
        });



        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Filter");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        filtr=(Button) view.findViewById(R.id.filtr_apply) ;


        filtr.setOnClickListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.country_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                view.findViewById(R.id.country);
        materialDesignSpinner.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.state_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner1 = (MaterialBetterSpinner)
                view.findViewById(R.id.state);
        materialDesignSpinner1.setAdapter(adapter1);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.city_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner)
                view.findViewById(R.id.city);
        materialDesignSpinner2.setAdapter(adapter2);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.village_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner3 = (MaterialBetterSpinner)
                view.findViewById(R.id.village);
        materialDesignSpinner3.setAdapter(adapter3);


        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.category_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner4 = (MaterialBetterSpinner)
                view.findViewById(R.id.category);
        materialDesignSpinner4.setAdapter(adapter4);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.order_array, android.R.layout.simple_spinner_item);
        MaterialBetterSpinner materialDesignSpinner5 = (MaterialBetterSpinner)
                view.findViewById(R.id.orderBy_tv);
        materialDesignSpinner5.setAdapter(adapter5);


        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }


        return  view;
    }

    @Override
    public void onClick(View view) {
        Fragment_Advance_Search advance = new Fragment_Advance_Search();
        mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame, advance, "advance").addToBackStack("advance").commit();
    }
}
