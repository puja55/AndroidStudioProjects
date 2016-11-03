package com.example.pri.molomartnew.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.pri.molomartnew.Adapter.Data_RecentlyListed;
import com.example.pri.molomartnew.Adapter.Adapter_RecentlyListed;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04/10/2016.
 */
public class Fragment_Advance_Search extends Fragment{

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public Fragment_Advance_Search(){
    }
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.frag_category_list, container, false);
        List<Data_RecentlyListed> dataB = fill_with_data();

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerview);
        Adapter_RecentlyListed adapter;
        adapter = new Adapter_RecentlyListed(dataB, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).showFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Advance Search");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        return rootView;

    }

    private List<Data_RecentlyListed> fill_with_data() {
        List<Data_RecentlyListed> dataB = new ArrayList<>();

        dataB.add(new Data_RecentlyListed("Chir Variation Boutique","www.healthservicing.org "," Boutique"," Indore"," 6823762317210","Chir Variation Boutique a garment boutique all type ladies garment , western ,indo-western,lahnga,blouse,salwar kamiz are available in one Boutique ", R.drawable.garden));
        dataB.add(new Data_RecentlyListed("Kasturi collection and Boutique","www.healthservicing.org "," Boutique"," Indore"," 6823762317210", "Dress material Salvar suit and saree ", R.drawable.mobile));
        dataB.add(new Data_RecentlyListed("Shravani- saree & Dress material","www.healthservicing.org "," Boutique"," Indore"," 6823762317210", "Various types of saree and Dress material are available at our shop. ", R.drawable.mk));
        dataB.add(new Data_RecentlyListed("shri hari telars","www.healthservicing.org ", " Boutique"," Indore"," 6823762317210","We hew taelars", R.drawable.garden));
        dataB.add(new Data_RecentlyListed("Shravani- saree & Dress material","www.healthservicing.org ", " Boutique"," Indore"," 6823762317210","Various types of saree and Dress material are available at our shop. ", R.drawable.mobile));
        dataB.add(new Data_RecentlyListed("Kasturi collection and Boutique","www.healthservicing.org "," Boutique"," Indore"," 6823762317210", "Dress material Salvar suit and saree ", R.drawable.mk));

        return dataB;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_filter, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.filter) {
            FragmentFilter filtr = new FragmentFilter();
            mFragmentManager = getActivity().getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame, filtr, "filtr").addToBackStack("filtr").commit();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_search).setVisible(false);

        super.onPrepareOptionsMenu(menu);
    }
}
