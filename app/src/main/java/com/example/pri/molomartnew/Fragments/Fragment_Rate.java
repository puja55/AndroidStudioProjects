package com.example.pri.molomartnew.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

/**
 * Created by User on 29/09/2016.
 */
public class Fragment_Rate extends Fragment {
    String ratedValue;
    public Fragment_Rate(){

    }
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.review_rate, container, false);
        final RatingBar rate = (RatingBar) rootView.findViewById(R.id.reviewrate);
        final TextView ratestar = (TextView) rootView.findViewById(R.id.rate_star);

this.setHasOptionsMenu(true);


        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                ratedValue = String.valueOf(rate.getRating());
                ratestar.setText("You have rated the Product : "
                        + ratedValue + "/5.");
            }
        });


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Rate");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }
        return rootView;
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
       // drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        super.onPrepareOptionsMenu(menu);
    }

}
