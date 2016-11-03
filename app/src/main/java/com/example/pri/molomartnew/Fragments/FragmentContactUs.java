package com.example.pri.molomartnew.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pri.molomartnew.NewMainActivity;
import com.example.pri.molomartnew.R;
import com.github.clans.fab.FloatingActionMenu;


/**
 * Created by Pri on 9/22/2016.
 */
public class FragmentContactUs extends Fragment {
    android.support.design.widget.TextInputEditText name,email,mobile,message,task;
    private static final String TAG = "FragmentContactUs";
    TextView captcha;

    NavigationView navigationView;
    public FragmentContactUs(){

    }
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View rootView=inflater.inflate(R.layout.fragment_contactus, container, false);
        name=(android.support.design.widget.TextInputEditText)rootView.findViewById(R.id.contact_name);
        email=(android.support.design.widget.TextInputEditText)rootView.findViewById(R.id.contact_email);
        mobile=(android.support.design.widget.TextInputEditText)rootView.findViewById(R.id.contact_mobile);
        message=(android.support.design.widget.TextInputEditText)rootView.findViewById(R.id.contact_msg);
        task=(android.support.design.widget.TextInputEditText)rootView.findViewById(R.id.contact_task);
        captcha=(TextView) rootView.findViewById(R.id.captcha);
      //  send=(Button) rootView.findViewById(R.id.contact_btn);
this.setHasOptionsMenu(true);
        final FloatingActionMenu fab = ((NewMainActivity) getActivity()).getFloatingActionMenu();
        if (fab != null) {
            ((NewMainActivity) getActivity()).showFloatingActionMenu();
        }


        toolbar=(Toolbar)getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Contact Us");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        drawerLayout = (DrawerLayout)getActivity(). findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) getActivity(). findViewById(R.id.nav_view);

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

//        send.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                contact();
//            }
//        });
        return rootView;
    }

    public void contact() {
        Log.d(TAG, "FragmentContactUs");

        if (!validate()) {
            onContactFailed();
            return;
        }

     //   send.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onContactSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

//    @Override
//    public void onBackPressed() {
//        // Disable going back to the FragmentDashboard
//        moveTaskToBack(true);
//    }

    public void onContactSuccess() {
        //send.setEnabled(true);
       // finish();
//        Intent intent=new Intent(LoginActivity.this,NewMainActivity.class);
//        startActivity(intent);

    }

    public void onContactFailed() {
        Toast.makeText(getActivity(), "Sending failed", Toast.LENGTH_LONG).show();

       // send.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name1 = name.getText().toString();
        String email1 = email.getText().toString();
        String mobile1 = mobile.getText().toString();
        String message1 = message.getText().toString();
        String task1 = task.getText().toString();

        if (name1.isEmpty() || name1.length() < 3) {
            name.setError("at least 3 characters");
            valid = false;
        } else {
            name.setError(null);
        }

        if (email1.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()) {
            email.setError("enter a valid email address");
            valid = false;
        } else {
            email.setError(null);
        }

        if (mobile1.isEmpty() || mobile1.length() < 10) {
            mobile.setError("type valid number");
            valid = false;
        } else {
            mobile.setError(null);
        }


        if (message1.isEmpty()) {
            message.setError("Type message");
            valid = false;
        } else {
            message.setError(null);
        }

        if (task1.isEmpty()) {
            task.setError("enter captcha");
            valid = false;
        } else {
            task.setError(null);
        }




        return valid;
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
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        super.onPrepareOptionsMenu(menu);
    }













}
