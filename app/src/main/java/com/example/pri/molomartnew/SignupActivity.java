package com.example.pri.molomartnew;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @Bind(R.id.input_name)
    TextInputEditText _nameText;
    @Bind(R.id.input_lastname)
    TextInputEditText _lastnameText;
    @Bind(R.id.input_email)
    TextInputEditText _emailText;
    @Bind(R.id.input_mobile)
    TextInputEditText _mobile;
    @Bind(R.id.input_password)
    TextInputEditText _passwordText;
    @Bind(R.id.input_cpassword)
    TextInputEditText _cpasswordText;
    @Bind(R.id.checkbox)
    CheckBox _checkbox;
    @Bind(R.id.terms)
    TextView _terms;
    @Bind(R.id.btn_signup)
    Button _signupButton;
    @Bind(R.id.link_login)
    TextView _loginLink;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String lastname = _lastnameText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobile.getText().toString();
        String password = _passwordText.getText().toString();
        String cpassword = _cpasswordText.getText().toString();
        String checkbox = _checkbox.getText().toString();
        String terms = _terms.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String lastname = _lastnameText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobile.getText().toString();
        String password = _passwordText.getText().toString();
        String cpassword = _cpasswordText.getText().toString();
        String checkbox = _checkbox.getText().toString();
        String terms = _terms.getText().toString();
        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (lastname.isEmpty() || lastname.length() < 3) {
            _lastnameText.setError("at least 3 characters");
            valid = false;
        } else {
            _lastnameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }
        if (mobile.isEmpty() || mobile.length() < 10) {
            _mobile.setError("type valid number");
            valid = false;
        } else {
            _mobile.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        if (cpassword.isEmpty() || cpassword.length() < 4 || cpassword.length() > 10) {
            _cpasswordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _cpasswordText.setError(null);
        }
//        if (checkbox.i) {
//            _checkbox.setError("You have to select Terms and Conditions");
//            valid = false;
//        } else {
//            _checkbox.setError(null);
//        }


        return valid;
    }
}