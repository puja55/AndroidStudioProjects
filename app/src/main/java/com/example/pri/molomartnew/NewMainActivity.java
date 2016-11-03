package com.example.pri.molomartnew;


import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.view.ContextThemeWrapper;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pri.molomartnew.Fragments.Fraagment_editprofile;
import com.example.pri.molomartnew.Fragments.Fragmen_help;
import com.example.pri.molomartnew.Fragments.FragmentRecently_Listed;
import com.example.pri.molomartnew.Fragments.FragmentDashboard;
import com.example.pri.molomartnew.Fragments.Fragment_Certicate_Package;
import com.example.pri.molomartnew.Fragments.Fragment_Advance_Search;
import com.example.pri.molomartnew.Fragments.Fragment_All_Business;
import com.example.pri.molomartnew.Fragments.Fragment_bulkemail;
import com.example.pri.molomartnew.Fragments.Fragment_emaailtracker;
import com.example.pri.molomartnew.Fragments.ListUrBusiness;
import com.example.pri.molomartnew.Fragments.Fragment_TopBusiness;
import com.example.pri.molomartnew.Fragments.Fagment_Top_Services;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by User on 17/09/2016.
 */
public class NewMainActivity extends AppCompatActivity
{
    com.github.clans.fab.FloatingActionMenu menuRed;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    TextView edittext;
    private ImageView imgNavHeaderBg, imgProfile;
    FloatingActionButton fab1, fab2, fab3;
    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();
    FrameLayout frame;
    Toolbar toolbar;
    FragmentManager mFragmentManager=getSupportFragmentManager();
    FragmentTransaction mFragmentTransaction;


//    private static final String urlNavHeaderBg = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";
//    private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";

    public static int navItemIndex = 0;
    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_USERPANEL = "userpanel";
    private static final String TAG_ADVANCEDSEARCH = "advancedsearch";
    private static final String TAG_HELP = "help";
    private static final String TAG_FAV = "fav";
    private static final String TAG_SHARE = "share";
    private static final String TAG_RATE = "rate";
    public static String CURRENT_TAG = TAG_HOME;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;
    private TextView txtName;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        frame = (FrameLayout) findViewById(R.id.frame);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mHandler = new Handler();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        menuRed = (com.github.clans.fab.FloatingActionMenu) findViewById(R.id.menu_red);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        edittext = (TextView) navHeader.findViewById(R.id.edtprofile);

        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>"+"MOLO MART"+"</font>"));
       // getSupportFragmentManager().addOnBackStackChangedListener(this);
       // toolbar.setNavigationIcon(R.drawable.arrow_right);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open navigation drawer when click navigation back button
                DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.START);
            }
        });

edittext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Fraagment_editprofile fraagment_editprofile = new Fraagment_editprofile();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame, fraagment_editprofile, "editprofile").addToBackStack("editprofile").commit();
        drawer.closeDrawers();
    }
});

        ContextThemeWrapper context = new ContextThemeWrapper(getApplicationContext(), R.style.MenuButtonsStyle);

        menuRed.setClosedOnTouchOutside(true);
        menuRed.hideMenuButton(false);
        menus.add(menuRed);
        fab1.setOnClickListener(clickListener);
        fab2.setOnClickListener(clickListener);
        fab3.setOnClickListener(clickListener);

        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //fabEdit.show(true);
            }
        }, delay + 150);

        menuRed.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuRed.isOpened()) {

                }

                menuRed.toggle(true);
            }
        });


        FragmentDashboard fragmentDashboard = new FragmentDashboard();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame, fragmentDashboard, "list").addToBackStack(null).commit();

    }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fab1:
                    Fagment_Top_Services top_services = new Fagment_Top_Services();
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame, top_services, "services").addToBackStack("services").commit();
                    menuRed.close(true);
                    break;
                case R.id.fab2:
                    FragmentRecently_Listed fragmentBusiness = new FragmentRecently_Listed();
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame, fragmentBusiness, "business").addToBackStack("business").commit();
                    menuRed.close(true);
                    break;
                case R.id.fab3:
                    Fragment_TopBusiness recently_listed = new Fragment_TopBusiness();
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.frame, recently_listed, "recently").addToBackStack("recently").commit();
                    menuRed.close(true);
                    break;
            }
        }
    };

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {
        // name, website
        txtName.setText("Hi User!");

        // loading header background image
        Glide.with(this).load(R.drawable.back3)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(R.drawable.ic_profile)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgProfile);
    }
    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            return;
        }
    }
    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu

            @SuppressWarnings("StatementWithEmptyBody")
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        FragmentDashboard homeFragment = new FragmentDashboard();
                        mFragmentManager = getSupportFragmentManager();
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        mFragmentTransaction.replace(R.id.frame, homeFragment, "home").addToBackStack("home").commit();
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_userpanel:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_USERPANEL;
                        navigationView.getMenu().clear();
                        navigationView.inflateMenu(R.menu.submenu);
                        Menu m = navigationView.getMenu();
                        SubMenu topChannelMenu = m.addSubMenu("User Panel");

                        // Add submenu.

                        topChannelMenu.add("Go back").setIcon(R.drawable.ic_star).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                navigationView.getMenu().clear();
                                navigationView.inflateMenu(R.menu.activity_main_drawer);
                                return true;
                            }
                        });

                        topChannelMenu.add("All Business").setIcon(R.drawable.ic_star).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                Fragment_All_Business fragment_allbusiness = new Fragment_All_Business();
                                mFragmentManager = getSupportFragmentManager();
                                mFragmentTransaction = mFragmentManager.beginTransaction();
                                mFragmentTransaction.replace(R.id.frame, fragment_allbusiness, "allbusiness").addToBackStack("allbusiness").commit();
                                drawer.closeDrawers();
                                return true;
                            }
                        });
                        topChannelMenu.add("New Business").setIcon(R.drawable.ic_star).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                ListUrBusiness listUrBusiness = new ListUrBusiness();
                                mFragmentManager = getSupportFragmentManager();
                                mFragmentTransaction = mFragmentManager.beginTransaction();
                                mFragmentTransaction.replace(R.id.frame, listUrBusiness, "newbusiness").addToBackStack("newbusiness").commit();
                                drawer.closeDrawers();
                                return true;
                            }
                        });
                        topChannelMenu.add("Email Tracker").setIcon(R.drawable.ic_star).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                Fragment_emaailtracker fragment_emaailtracker = new Fragment_emaailtracker();
                                mFragmentManager = getSupportFragmentManager();
                                mFragmentTransaction = mFragmentManager.beginTransaction();
                                mFragmentTransaction.replace(R.id.frame, fragment_emaailtracker, "emailtracker").addToBackStack("emailtracker").commit();
                                drawer.closeDrawers();
                                return true;
                            }
                        });
                        topChannelMenu.add("Bulk Email").setIcon(R.drawable.ic_star).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {

                                Fragment_bulkemail fragment_bulkemail = new Fragment_bulkemail();
                                mFragmentManager = getSupportFragmentManager();
                                mFragmentTransaction = mFragmentManager.beginTransaction();
                                mFragmentTransaction.replace(R.id.frame, fragment_bulkemail, "bulkemail").addToBackStack("bulkemail").commit();
                                drawer.closeDrawers();
                                return true;
                            }
                        });;


                        MenuItem mi = m.getItem(m.size()-1);
                        mi.setTitle(mi.getTitle());

                        break;

                    case R.id.nav_advancedsearch:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_ADVANCEDSEARCH;
                        Fragment_Advance_Search fragment_advance = new Fragment_Advance_Search();
                        mFragmentManager = getSupportFragmentManager();
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        mFragmentTransaction.replace(R.id.frame, fragment_advance, "advance").addToBackStack("advance").commit();
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_help:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_HELP;
                        Fragmen_help fragmen_help = new Fragmen_help();
                        mFragmentManager = getSupportFragmentManager();
                        mFragmentTransaction = mFragmentManager.beginTransaction();
                        mFragmentTransaction.replace(R.id.frame, fragmen_help, "help").addToBackStack("help").commit();
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_fav:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_FAV;
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_share:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_SHARE;
                        drawer.closeDrawers();
                        break;
                    case R.id.nav_rate:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_RATE;
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_listpackage:
                            ListUrBusiness listUrBusiness = new ListUrBusiness();
                            mFragmentManager = getSupportFragmentManager();
                            mFragmentTransaction = mFragmentManager.beginTransaction();
                            mFragmentTransaction.replace(R.id.frame, listUrBusiness, "listurbusiness").addToBackStack("listurbusiness").commit();
                            drawer.closeDrawers();
                            break;
                    case R.id.nav_certificatepackage:

                            Fragment_Certicate_Package fragment_certicate_package = new Fragment_Certicate_Package();
                            mFragmentManager = getSupportFragmentManager();
                            mFragmentTransaction = mFragmentManager.beginTransaction();
                            mFragmentTransaction.replace(R.id.frame, fragment_certicate_package, "listurbusiness").addToBackStack("listurbusiness").commit();
                            drawer.closeDrawers();
                            break;


                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
    @Override
    public void onBackPressed() {


        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count <= 0) {
            super.onBackPressed();
        } else if (count == 1) {
            FragmentDashboard fragmentDashboard = new FragmentDashboard();
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame, fragmentDashboard, "list").addToBackStack("List").commit();

            if (menuRed.isOpened()) {
                menuRed.close(true);

            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Do you want to Exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user pressed "yes", then he is allowed to exit from application

                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // /if user select "No", just cancel this dialog and continue with app
                    dialog.cancel();
                }
            });


            AlertDialog alert = builder.create();
            alert.show();
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        getMenuInflater().inflate( R.menu.main, menu);


        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_logout) {
//            Intent intent = new Intent(NewMainActivity.this, LoginActivity.class);
//            startActivity(intent);
//            return true;
//        }
// else if (id == R.id.action_search) {
//            final MenuItem myActionMenuItem = MenuItem.
//
//            addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                    // When user changed the Text
//                    NewMainActivity.this.adapter.getFilter().filter(cs);
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                              int arg3) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable arg0) {
//                    // TODO Auto-generated method stub
//                }
//            });
//        }
        return super.onOptionsItemSelected(item);

        }
    public FloatingActionMenu getFloatingActionMenu() {
        return menuRed;
    }

    public void showFloatingActionMenu() {
        menuRed.showMenu(true);
    }

    public void hideFloatingActionMenu() {
        menuRed.hideMenu(true);
    }


}



