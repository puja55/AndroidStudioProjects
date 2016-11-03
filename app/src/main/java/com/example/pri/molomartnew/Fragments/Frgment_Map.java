package com.example.pri.molomartnew.Fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.v4.app.Fragment;

/**
 * Created by User on 29/09/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pri.molomartnew.Adapter.ViewPagerAdapter;
import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.example.pri.molomartnew.utils.NonScrollListView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.viewpagerindicator.CirclePageIndicator;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.List;

import static com.example.pri.molomartnew.R.id.toolbar1;


/**
 * Created by Pri on 9/21/2016.
 */
public class Frgment_Map extends Fragment implements View.OnClickListener  {


    LinearLayout openlinear,detaillinear;
    Toolbar mToolbar;
    Resources mResources;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    String[] Spiner = {"Oldest", "Newest"};
    CollapsingToolbarLayout collapsingToolbar;
    //    NonScrollListView nonScrollListView;

    MaterialFavoriteButton favorite ;
    ScrollView scrollView;
    ViewPager viewPager;
    Spinner spinner;
    ImageView overflow;
    FloatingActionButton googlefab;
    CirclePageIndicator indicator;
    AppBarLayout appBarLayout;
    TextView added, loc, email, website, mobile, contactperson, views, desc;
    TextView mtime, tuestime, wtime, thrustime, fritime, sattime, suntime, address;
    Button contact, gallery, social,hide,show;
    int[] mImages = {R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,
            R.drawable.bannr,

    };
    int flag = 1;

    public Frgment_Map() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.business_map, container, false);

        openlinear=(LinearLayout)view.findViewById(R.id.openinglinear) ;
        detaillinear=(LinearLayout)view.findViewById(R.id.detaillinear) ;
        viewPager = (ViewPager) view.findViewById(R.id.busines_view);
        overflow=(ImageView)view.findViewById(R.id.overflowmap);
       // fav=(ImageView)view.findViewById(R.id.ic_fav);
        added = (TextView) view.findViewById(R.id.aded_nm1);
        loc = (TextView) view.findViewById(R.id.aded_nm2);
        email = (TextView) view.findViewById(R.id.aded_nm3);
        website = (TextView) view.findViewById(R.id.aded_nm4);
        mobile = (TextView) view.findViewById(R.id.aded_nm5);
        contactperson = (TextView) view.findViewById(R.id.aded_nm6);
        views = (TextView) view.findViewById(R.id.aded_nm7);
        desc = (TextView) view.findViewById(R.id.description);
        mtime = (TextView) view.findViewById(R.id.mndy_time);
        tuestime = (TextView) view.findViewById(R.id.tuesdy_time);
        wtime = (TextView) view.findViewById(R.id.wdnsdy_time);
        thrustime = (TextView) view.findViewById(R.id.thusdy_time);
        favorite=(MaterialFavoriteButton)view.findViewById(R.id.favicon);
        fritime = (TextView) view.findViewById(R.id.frydy_time);
        sattime = (TextView) view.findViewById(R.id.strdy_time);
        suntime = (TextView) view.findViewById(R.id.sndy_time);
        contact = (Button) view.findViewById(R.id.mapcontact);
        gallery = (Button) view.findViewById(R.id.mapgallery);
        social = (Button) view.findViewById(R.id.mapsocial);
        show = (Button) view.findViewById(R.id.more);
        hide = (Button) view.findViewById(R.id.hide);
        social = (Button) view.findViewById(R.id.mapsocial);
        googlefab=(FloatingActionButton)view.findViewById(R.id.googlemap_fab);
        spinner = (Spinner) view.findViewById(R.id.spinner1);
        mToolbar = (Toolbar) view.findViewById(toolbar1);
        collapsingToolbar = (CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar);

        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar);
        indicator = (CirclePageIndicator) view.findViewById(R.id.busines_viewindicator);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity(), mImages);
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
      //  actionBar.setTitle("First Fragment");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCategory_List fragmentList = new FragmentCategory_List();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentList, "list").addToBackStack("list").commit();
            }
        });
        googlefab.setBackgroundColor(Color.parseColor("#ADC531"));

                final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).hideFloatingActionMenu();
        }
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        initCollapsingToolbar();
        favorite.setOnFavoriteChangeListener(

                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {

                        if(flag == 1){
                            collapsingToolbar.setTitle("MOLOMART");
                            Toast.makeText(getActivity().getApplicationContext(),"Added in favoraite",Toast.LENGTH_SHORT).show();
                                flag = 0;
                        }else{
                            collapsingToolbar.setTitle("MOLOMART");
                            Toast.makeText(getActivity().getApplicationContext(),"Remove from favoraite",Toast.LENGTH_SHORT).show();
                            flag=1;
                        }
                    }
                });

       /* favorite.setOnFavoriteAnimationEndListener(
                new MaterialFavoriteButton.OnFavoriteAnimationEndListener() {
                    @Override
                    public void onAnimationEnd(MaterialFavoriteButton buttonView, boolean favorite) {

                    }
                });
       */ show.setOnClickListener(this);
        hide.setOnClickListener(this);
      //  fav.setOnClickListener(this);
        contact.setOnClickListener(this);
        gallery.setOnClickListener(this);
        social.setOnClickListener(this);
        overflow.setOnClickListener(this);

        return view;
    }




    //
//    /**
//     * Initializing collapsing toolbar
//     * Will show and hide the toolbar title on scroll
//     */
    private void initCollapsingToolbar() {
        collapsingToolbar.setTitle(" ");
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("MOLOMART");

                  //  mToolbar.setTitle("MOLOMART");
                  //  collapsingToolbar.setBackgroundColor(getResources().getColor(R.color.blue));

                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more:

                if (openlinear.getVisibility() == View.GONE) {
                    openlinear.setVisibility(View.VISIBLE);
                    detaillinear.setVisibility(View.VISIBLE);
                    hide.setVisibility(View.VISIBLE);

                }
                show.setVisibility(View.INVISIBLE);
                break;

            case R.id.hide:

                if (openlinear.getVisibility() == View.VISIBLE) {
                    openlinear.setVisibility(View.GONE);
                    detaillinear.setVisibility(View.VISIBLE);
                    show.setVisibility(View.VISIBLE);


                }
                hide.setVisibility(View.INVISIBLE);
                break;
//            case R.id.ic_fav:
//


//                boolean isFavourite = getActivity().readState();
//
//                if (isFavourite) {
//                    fav.setBackgroundResource(R.drawable.ic_favorite_white_24dp);
//                    Toast.makeText(getActivity(), "Add to favourite", Toast.LENGTH_SHORT).show();
//                    isFavourite = false;
//                    saveState(isFavourite);
//
//                }
//                else {
//                    fav.setBackgroundResource(R.drawable.ic_fav);
//                    isFavourite = true;
//                    saveState(isFavourite);
//
//                }
              //  break;

            case R.id.overflowmap:
                showPopupMenu(overflow);
                break;
            case R.id.mapcontact:
                FragmentContact fragmentContact = new FragmentContact();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentContact, "contact").addToBackStack("contact").commit();
                break;

            case R.id.mapgallery:
                Fragment_Image_Gallery fragmentZoom = new Fragment_Image_Gallery();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentZoom, "img").addToBackStack("img").commit();
                break;

            case R.id.mapsocial:

                FragmentSocial fragmentSocial = new FragmentSocial();
                mFragmentManager = getActivity().getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame, fragmentSocial, "social").addToBackStack("social").commit();
                break;

            default:
                break;
        }
    }
    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch (menuItem.getItemId()) {

                case R.id.action_add_tag:
                    Fragment_Tag fragment_tag=new Fragment_Tag();
                    mFragmentManager = getActivity().getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame,fragment_tag, "tag").addToBackStack("Tag").commit();
                    return true;

                case R.id.action_share:
                    Toast.makeText(getActivity(), "Share", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.action_rate:
                    Fragment_Rate fragment_rate=new Fragment_Rate();
                    mFragmentManager = getActivity().getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame,fragment_rate, "rate").addToBackStack("Rate").commit();
                    return true;

                default:
            }
            return false;
        }

    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

}
