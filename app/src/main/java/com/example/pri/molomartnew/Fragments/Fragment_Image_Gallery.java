package com.example.pri.molomartnew.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ScrollView;

import com.example.pri.molomartnew.Adapter.Data_Image_Gallery;
import com.example.pri.molomartnew.Adapter.Adapter_Image_Gallery;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;


//import android.support.design.widget.AppBarLayout;

public class Fragment_Image_Gallery extends Fragment {

   private RecyclerView recyclerView;
    private Adapter_Image_Gallery adapter;
    private List<Data_Image_Gallery> albumList;
    Context context;
  //  NonScrollListView nonScrollListView;
    ScrollView scrollView;
    Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_img_gallery, container, false);
        context = (Context) getActivity();

        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Gallery");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        recyclerView = (RecyclerView) view.findViewById(R.id.businessrecyclerview);
        albumList = new ArrayList<>();
        recyclerView.setFocusable(false);
        adapter = new Adapter_Image_Gallery(getActivity(), albumList);


        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }


        GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new GridItemDecoration());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(1), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setItemAnimator(new SlideInLeftAnimator());
        recyclerView.getItemAnimator().setAddDuration(1000);
        SlideInLeftAnimator animator = new SlideInLeftAnimator();
        animator.setInterpolator(new OvershootInterpolator());
// or recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f));
        recyclerView.setItemAnimator(animator);
        recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter));
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

        Data_Image_Gallery a = new Data_Image_Gallery("Architecture,Trader", covers[0]);
        albumList.add(a);

        a = new Data_Image_Gallery("Automobile,Car", covers[1]);
        albumList.add(a);

        a = new Data_Image_Gallery("Bill & Recharge",  covers[2]);
        albumList.add(a);

        a = new Data_Image_Gallery("Boutique,Tailor",  covers[3]);
        albumList.add(a);

        a = new Data_Image_Gallery("Caterer,Party",  covers[4]);
        albumList.add(a);

        a = new Data_Image_Gallery("Computer, Repairs", covers[5]);
        albumList.add(a);

        a = new Data_Image_Gallery("Courier Services",  covers[6]);
        albumList.add(a);

        a = new Data_Image_Gallery("Digital Arts", covers[7]);
        albumList.add(a);

        a = new Data_Image_Gallery("Education,Schools",covers[8]);
        albumList.add(a);

        a = new Data_Image_Gallery("Electronics",  covers[9]);
        albumList.add(a);

        a = new Data_Image_Gallery("Events",  covers[10]);
        albumList.add(a);

        a = new Data_Image_Gallery("Groccery,Dairy", covers[11]);
        albumList.add(a);

        a = new Data_Image_Gallery("Hospital",  covers[12]);
        albumList.add(a);

        a = new Data_Image_Gallery("Hotels and Resorts",  covers[13]);
        albumList.add(a);

        a = new Data_Image_Gallery("Insaurance",  covers[14]);
        albumList.add(a);

        a = new Data_Image_Gallery("Jewellery,Handicrafts", covers[15]);
        albumList.add(a);

        a = new Data_Image_Gallery("Loan,Finance",  covers[16]);
        albumList.add(a);

        a = new Data_Image_Gallery("Medical", covers[17]);
        albumList.add(a);

        a = new Data_Image_Gallery("Movies",covers[18]);
        albumList.add(a);

        a = new Data_Image_Gallery("Offices",covers[19]);
        albumList.add(a);

        a = new Data_Image_Gallery("Others",covers[20]);
        albumList.add(a);

        a = new Data_Image_Gallery("Personal Care",covers[21]);
        albumList.add(a);

        a = new Data_Image_Gallery("Plumber,Electrician",covers[22]);
        albumList.add(a);

        a = new Data_Image_Gallery("Printing",covers[23]);
        albumList.add(a);

        a = new Data_Image_Gallery("Real Estate",covers[24]);
        albumList.add(a);

        a = new Data_Image_Gallery("Repairs,Mobile",covers[25]);
        albumList.add(a);

        a = new Data_Image_Gallery("Restaurents",covers[26]);
        albumList.add(a);

        a = new Data_Image_Gallery("Security Services",covers[27]);
        albumList.add(a);

        a = new Data_Image_Gallery("Shop",covers[28]);
        albumList.add(a);

        a = new Data_Image_Gallery("Training Institutes",  covers[29]);
        albumList.add(a);

        a = new Data_Image_Gallery("Travelling",covers[30]);
        albumList.add(a);

        a = new Data_Image_Gallery("WaterPurifiers,Services",  covers[31]);
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
        private int mHorizontalSpacing = -10;
        private int mVerticalSpacing = -10;

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


}