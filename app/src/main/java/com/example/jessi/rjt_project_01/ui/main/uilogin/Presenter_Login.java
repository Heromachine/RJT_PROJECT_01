package com.example.jessi.rjt_project_01.ui.main.uilogin;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.rjt_project_01.AppController;
import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.localdata.Model_LocalData;
import com.example.jessi.rjt_project_01.data.localdata.Model_Validation;
import com.example.jessi.rjt_project_01.data.models.Model_Product;
import com.example.jessi.rjt_project_01.ui.main.uisignup.View_SignUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Presenter_Login implements IPresenter_Login {
    private static final String TAG = "Presenter_Login";

    View_Login VL;
    IView_Login VIL;
    Model_Validation MVL;
    String error;
    Model_LocalData SP;
    Switch swchLogin;

    String sUsername;
    String sPassword;

    Context cntx;

    private final ArrayList<String> LOGINPATTERNS = new ArrayList<String>();
    private final ArrayList<String>  LOGINFEILDNAMES = new ArrayList<String>();

    public Presenter_Login(View_Login mainActivity) {

        cntx = mainActivity;

        //swchLogin = mainActivity.findViewById(R.id);
        VIL = mainActivity;
        VL = mainActivity;

        SP = new Model_LocalData();
        SP.createSP(mainActivity, "LogInSP");

        if (SP.isSP(mainActivity, "LogInSP", "username") && SP.isSP(mainActivity, "LogInSP", "password")) {
            sUsername = SP.getSP(mainActivity, "LogInSP", "username");
            sPassword = SP.getSP(mainActivity, "LogInSP", "password");
        }

        LOGINPATTERNS.add("^[ A-Za-z0-9._-]{3,15}$");
        LOGINPATTERNS.add("^[A-Za-z0-9.-_!]{6,18}$");
        LOGINFEILDNAMES.add("Username:");
        LOGINFEILDNAMES.add("Password:");

        this.MVL = new Model_Validation(LOGINPATTERNS, LOGINFEILDNAMES);
    }


    @Override
    public void iPresenter_OnButtonClicked(View view, Context context, String username, String password) {
        Log.d(TAG, "iPresenter_OnButtonClicked: ");
        switch(view.getId())
        {
            case R.id.btn_li_login:
            this.MVL.addTextViewString(username);
            this.MVL.addTextViewString(password);
            break;

            case R.id.btn_li_go_to_signup:
                Intent i = new Intent(context, View_SignUp.class);
                context.startActivity(i);

                break;
        }
    }

    public String getLoginUrl(String phone, String password)
    {
       String url = " http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?mobile="+phone+"&password="+password;

        return url;
    }

    public void callJSONLogin(String phone, String password)
    {
        Log.d(TAG, "iPresenter_VolleyItemRequest: ");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                getLoginUrl(phone, password),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "onResponse: " + response.toString());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public String returnUsername() {
        return null;
    }

    @Override
    public String returnPassword() {
        return null;
    }

    @Override
    public void setUserName(String username) {

    }

    @Override
    public void setPassWord(String password) {

    }

    @Override
    public void iPresenter_giveViewEditTextString(View view) {

    }
}
