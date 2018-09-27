package com.example.jessi.rjt_project_01.ui.main.uisignup;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jessi.rjt_project_01.AppController;
import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.localdata.ModelValidation;
import com.example.jessi.rjt_project_01.data.models.ModelSignUp;
import com.example.jessi.rjt_project_01.ui.main.uilogin.ViewLoginMainActivity;

import java.util.ArrayList;

public class Presenter_SignUp implements IPresenter_SignUp {
    private static final String TAG = "Presenter_SignUp";
    private IView_SignUp iViewSignUp;
    private ModelValidation modelValidation;
    private ModelSignUp modelSignUp;
    private String error;
    private String fname;
    private String lname;
    private String address;
    private String password;
    private String email;
    private String mobile;

    private final ArrayList<String> SIGNINPATTERNS = new ArrayList<String>();
    private final ArrayList<String> SIGNINFEILDNAMES = new ArrayList<String>();

    public Presenter_SignUp(View_SignUp mainActivity)
    {
        iViewSignUp = new View_SignUp();
        iViewSignUp = mainActivity;

        SIGNINPATTERNS.add ("^[ A-Za-z]{3,15}$"); //FirstName
        SIGNINPATTERNS.add ("^[A-Za-z0-9]{3,18}$"); //LastName
        SIGNINPATTERNS.add ("^[A-Za-z0-9 ]{6,18}$");//address
        SIGNINPATTERNS.add("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");//password^
        SIGNINPATTERNS.add ("^[a-zA-Z0-9._-]{3,20}@[a-zA-Z0-9]{3,9}.com$"); //email
        SIGNINPATTERNS.add ("^(\\d{3}?\\d{3}?\\d{4})$");

        SIGNINFEILDNAMES.add("First Name: ");
        SIGNINFEILDNAMES.add("Last Name: ");
        SIGNINFEILDNAMES.add("Address: ");
        SIGNINFEILDNAMES.add("Password: ");
        SIGNINFEILDNAMES.add("Email: ");
        SIGNINFEILDNAMES.add("Mobile Phone: ");

        this.modelValidation = new ModelValidation(SIGNINPATTERNS, SIGNINFEILDNAMES);
    }


    @Override
    public void iPresenter_OnButtonClicked(View view, Context context, String fname, String lname, String address, String password, String email, String mobile)
    {
      this.fname = fname;
      this.lname = lname;
      this.address = address;
      this.password = password;
      this.email = email;
      this.mobile = mobile;

        switch(view.getId())
        {
            case R.id.btn_su_register:

                this.modelValidation.addTextViewString(this.fname);
                this.modelValidation.addTextViewString(this.lname);
                this.modelValidation.addTextViewString(this.address);
                this.modelValidation.addTextViewString(this.password);
                this.modelValidation.addTextViewString(this.email);
                this.modelValidation.addTextViewString(this.mobile);
                boolean temp = modelValidation.validation();

                if (!temp)
                {
                    Log.d(TAG, "iPresenter_OnButtonClicked: VALIDATION FAILED");
                    Toast.makeText(context, "\nInvalid Form", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "iPresenter_OnButtonClicked: =====================ERROR: "+ this.modelValidation.getErrormsg());

                }
                else
                {
                    Log.d(TAG, "iPresenter_OnButtonClicked: VALIDATION PASSED");
                    modelSignUp = new ModelSignUp(this.fname, this.lname, this.address, this.password, this.email, this.mobile);
                    setURL();
                    RegistrationRequest(modelSignUp.getUrl());

                    if (modelSignUp.isRegistered()) {
                        Log.d(TAG, "iPresenter_OnButtonClicked: REGISTRATION PASSED");
                        Toast.makeText(context, "Registration Succesful!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context, ViewLoginMainActivity.class);
                        context.startActivity(i);
                    }
                    else
                    {
                        Log.d(TAG, "iPresenter_OnButtonClicked: REGISTRATION FAILED");
                        Toast.makeText(context, "Registration Failed!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "User Exists", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btn_su_login:
                Intent i = new Intent(context, ViewLoginMainActivity.class);
                context.startActivity(i);
                break;
        }
    }

    public void RegistrationRequest(String url)
    {
        Log.d(TAG, "\nRegistrationRequest: STARTED /URL = "+ url );
        boolean registered = false;

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.toString().contentEquals("successfully registered")) {
                            modelSignUp.setRegistered(true);
                            Log.d(TAG, "onResponse: \n\n==========REGISTRATION SUCCESS: " + response.toString());
                        }
                        else {
                            modelSignUp.setRegistered(false);
                            Log.d(TAG, "onResponse: \n\n==========REGISTRATION FAILED: " + response.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onResponse: \n\n==========REGISTRATION ERROR: "+error.toString());
                    }
                });

        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    private void setURL()
    {
        Log.d(TAG, "setURL: ");
        String url = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_reg.php?fname=" +modelSignUp.getFname()
                +"&lname=" + modelSignUp.getLname()
                +"&address=" +modelSignUp.getAddress()
                +"&email="+modelSignUp.getEmail()
                +"&mobile="+modelSignUp.getMobile()
                +"&password="+modelSignUp.getPassword();
        Log.d(TAG, "setURL: "+ url);
        modelSignUp.setUrl(url);
    }
}
