package com.example.pri.molomartnew.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;


import com.example.pri.molomartnew.Adapter.Data_dashboard;
import com.example.pri.molomartnew.Adapter.Adapter_Dashboard;
import com.example.pri.molomartnew.Adapter.ViewPagerAdapter;
import com.example.pri.molomartnew.LoginActivity;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.example.pri.molomartnew.utils.NonScrollListView;
import com.github.clans.fab.FloatingActionMenu;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;



//import android.support.design.widget.AppBarLayout;

public class FragmentDashboard extends Fragment {

   private RecyclerView recyclerView;
    private Adapter_Dashboard adapter;
    private List<Data_dashboard> albumList;
    Context context;
    NonScrollListView nonScrollListView;
    ScrollView scrollView;
    ViewPager viewPager;
    CirclePageIndicator indicator;
int position;
    int []mImages = {R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,

    };
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_dashboard, container, false);
        context = (Context) getActivity();

this.setHasOptionsMenu(true);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        indicator = (CirclePageIndicator)view.findViewById(R.id.indicator);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity(),mImages);
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        nonScrollListView = (NonScrollListView) view.findViewById(R.id.lv_politics);
        nonScrollListView.setFocusable(false);
        recyclerView.setFocusable(false);
        adapter = new Adapter_Dashboard(getActivity(), albumList);

        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).showFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Molo Mart");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new GridItemDecoration());

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(1), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);

        prepareAlbums();



        return view;
    }



    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.architecture,
                R.drawable.autombile,
                R.drawable.bill,
                R.drawable.boutique,
                R.drawable.caterer,
                R.drawable.computer,
                R.drawable.courier,
                R.drawable.digital,
                R.drawable.education,
                R.drawable.electronics,
                R.drawable.architecture,
                R.drawable.autombile,
                R.drawable.bill,
                R.drawable.boutique,
                R.drawable.caterer,
                R.drawable.computer,
                R.drawable.courier,
                R.drawable.digital,
                R.drawable.education,
                R.drawable.electronics,
                R.drawable.education,
                R.drawable.electronics,
                R.drawable.bill,
                R.drawable.boutique,
                R.drawable.caterer,
                R.drawable.computer,
                R.drawable.courier,
                R.drawable.digital,
                R.drawable.education,
                R.drawable.electronics,
                R.drawable.education,
                R.drawable.electronics
                };

        Data_dashboard a = new Data_dashboard("Architecture,Trader",  covers[0]);
        albumList.add(a);

        a = new Data_dashboard("Automobile,Car", covers[1]);
        albumList.add(a);

        a = new Data_dashboard("Bill & Recharge",  covers[2]);
        albumList.add(a);

        a = new Data_dashboard("Boutique,Tailor",  covers[3]);
        albumList.add(a);

        a = new Data_dashboard("Caterer,Party",  covers[4]);
        albumList.add(a);

        a = new Data_dashboard("Computer, Repairs", covers[5]);
        albumList.add(a);

        a = new Data_dashboard("Courier Services",  covers[6]);
        albumList.add(a);

        a = new Data_dashboard("Digital Arts", covers[7]);
        albumList.add(a);

        a = new Data_dashboard("Education,Schools",covers[8]);
        albumList.add(a);

        a = new Data_dashboard("Electronics",  covers[9]);
        albumList.add(a);

        a = new Data_dashboard("Events",  covers[10]);
        albumList.add(a);

        a = new Data_dashboard("Groccery,Dairy", covers[11]);
        albumList.add(a);

        a = new Data_dashboard("Hospital",  covers[12]);
        albumList.add(a);

        a = new Data_dashboard("Hotels and Resorts",  covers[13]);
        albumList.add(a);

        a = new Data_dashboard("Insaurance",  covers[14]);
        albumList.add(a);

        a = new Data_dashboard("Jewellery,Handicrafts", covers[15]);
        albumList.add(a);

        a = new Data_dashboard("Loan,Finance",  covers[16]);
        albumList.add(a);

        a = new Data_dashboard("Medical", covers[17]);
        albumList.add(a);

        a = new Data_dashboard("Movies",covers[18]);
        albumList.add(a);

        a = new Data_dashboard("Offices",covers[19]);
        albumList.add(a);

        a = new Data_dashboard("Others",covers[20]);
        albumList.add(a);

        a = new Data_dashboard("Personal Care",covers[21]);
        albumList.add(a);

        a = new Data_dashboard("Plumber,Electrician",covers[22]);
        albumList.add(a);

        a = new Data_dashboard("Printing",covers[23]);
        albumList.add(a);

        a = new Data_dashboard("Real Estate",covers[24]);
        albumList.add(a);

        a = new Data_dashboard("Repairs,Mobile",covers[25]);
        albumList.add(a);

        a = new Data_dashboard("Restaurents",covers[26]);
        albumList.add(a);

        a = new Data_dashboard("Security Services",covers[27]);
        albumList.add(a);

        a = new Data_dashboard("Shop",covers[28]);
        albumList.add(a);

        a = new Data_dashboard("Training Institutes",  covers[29]);
        albumList.add(a);

        a = new Data_dashboard("Travelling",covers[30]);
        albumList.add(a);

        a = new Data_dashboard("WaterPurifiers,Services",  covers[31]);
        albumList.add(a);
        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    public class GridItemDecoration extends RecyclerView.ItemDecoration
    {
        private int mHorizontalSpacing = -15;
        private int mVerticalSpacing = -15;

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
        {
            super.getItemOffsets(outRect, view, parent, state);
            // Only handle the vertical situation
            int position = parent.getChildPosition(view);
            if (parent.getLayoutManager() instanceof GridLayoutManager)
            {
                GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
                int spanCount, column;
                // Check the last item and is alone. Then set the parent's width
                if (position == parent.getAdapter().getItemCount() - 1 && position % 2 == 0)
                {
                    spanCount = 1;
                    outRect.left = mHorizontalSpacing;
                    outRect.right = parent.getWidth() - mHorizontalSpacing;
                }
                else
                {
                    spanCount = layoutManager.getSpanCount();
                    column = position % spanCount;
                    outRect.left = mHorizontalSpacing * (spanCount - column) / spanCount;
                    outRect.right = mHorizontalSpacing * (column + 1) / spanCount;
                }

                if (position < spanCount)
                {
                    outRect.top = mVerticalSpacing;
                }
                outRect.bottom = mVerticalSpacing;
            }
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

       // menu.getItem(1).setIcon(R.drawable.logout);
        super.onCreateOptionsMenu(menu, inflater);
       // menu.clear();
        inflater.inflate(R.menu.menu_logout, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);

            startActivity(intent);

        }
        return true;
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_search).setVisible(true);
//menu.findItem(1).setIcon(R.drawable.logout);
        super.onPrepareOptionsMenu(menu);
    }



}