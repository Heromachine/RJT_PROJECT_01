package com.example.jessi.rjt_project_01.ui.main.uilogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.jessi.rjt_project_01.AppController;
import com.example.jessi.rjt_project_01.SharedPref;
import com.example.jessi.rjt_project_01.ui.main.main.MainActivity;
import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.localdata.ModelSharedPreference;
import com.example.jessi.rjt_project_01.data.localdata.ModelValidation;
import com.example.jessi.rjt_project_01.data.models.ModelCategory;
import com.example.jessi.rjt_project_01.data.models.ModelLogIn;
import com.example.jessi.rjt_project_01.ui.main.uiproductlist.Presenter_ProductList;
import com.example.jessi.rjt_project_01.ui.main.uisignup.View_SignUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;

public class PresenterLogin implements IPresenter_Login {

    private static final String TAG = "PresenterLogin";
    private String phone;
    private String password;
    private IViewLogin iViewLogin;
    private ModelSharedPreference modelLocalData;
    private ModelCategory modelCategory;
    static String error;
    private Context mctx;
    private final ArrayList<String> LOGINPATTERNS = new ArrayList<String>();
    private final ArrayList<String>  LOGINFEILDNAMES = new ArrayList<String>();

    ModelLogIn modelLogIn;
    //---------------------------------------
    ModelValidation modelValidation;
    //---------------------------------------

    String tempURL = "http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?mobile=5129094836&password=12345apple";

    public PresenterLogin(ViewLoginMainActivity mainActivity) {

        iViewLogin = new ViewLoginMainActivity();
        iViewLogin = mainActivity;
        mctx = mainActivity;

        modelLocalData = new ModelSharedPreference();
        modelLocalData.createSP(mainActivity, "LogInSP");

        if (modelLocalData.isSP(mainActivity, "LogInSP", "phone") && modelLocalData.isSP(mainActivity, "LogInSP", "password")) {
            phone = modelLocalData.getSP(mainActivity, "LogInSP", "phone");
            password = modelLocalData.getSP(mainActivity, "LogInSP", "password");
        }

        LOGINPATTERNS.add("^(\\d{3}?\\d{3}?\\d{4})$");
        LOGINPATTERNS.add("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        LOGINFEILDNAMES.add("Phone:");
        LOGINFEILDNAMES.add("Password:");
        this.modelValidation = new ModelValidation(LOGINPATTERNS, LOGINFEILDNAMES);
    }


    @Override
    public void iPresenter_OnButtonClicked(View view, Context context, String phone, String password) {

        this.phone =  phone;
        this.password = password;

        switch(view.getId())
        {
            case R.id.btn_li_login:

            this.modelValidation.addTextViewString(phone);
            this.modelValidation.addTextViewString(password);
            boolean temp = modelValidation.validation();
            
            if (!temp)
            {
                Toast.makeText(context, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String forJsonRequest = getLoginUrl(phone, password);
                callJSONLogin(forJsonRequest, phone, password);

                Toast.makeText(context, "Login Succesful", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
                break;
            }

            break;

            case R.id.btn_li_go_to_signup:
                Intent i = new Intent(context, View_SignUp.class);
                context.startActivity(i);

                 this.modelLogIn.getAppapikey();
                break;
        }
    }

    public String getLoginUrl(String phone, String password)
    {
        String url = " http://rjtmobile.com/aamir/e-commerce/android-app/shop_login.php?mobile="+phone+"&password="+password;

        return url;
    }

    public void callJSONLogin(String URL, String phone, String password)
    {
        final String url = getLoginUrl(phone, password);
        Log.d(TAG, "callJSONLogin: STARTED");
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "onResponse: RESPONSE ");
                        try
                        {
                            Log.d(TAG, "onResponse: TRY **************************");
                            JSONObject catObject = response.getJSONObject(0);
                            ModelLogIn modelLogIn = new ModelLogIn(
                                    catObject.getString("msg"),
                                    catObject.getString("id"),
                                    catObject.getString("firstname"),
                                    catObject.getString("lastname"),
                                    catObject.getString("email"),
                                    catObject.getString("mobile"),
                                    catObject.getString("appapikey"));

                            Log.d(TAG, "onResponse: modelLogIn: "+modelLogIn.getAppapikey());
                            setModelLogin(modelLogIn);
//                            Intent mIntent = new Intent(mctx, ViewLoginMainActivity.class);
//                            Bundle mBundle = new Bundle();
//                            mBundle.putString("appkey", catObject.getString("appapikey"));
//                            mIntent.putExtras(mBundle);

                            SharedPref.init(mctx);
                            SharedPref.write(SharedPref.API_KEY, modelLogIn.getAppapikey());
                            Log.d(TAG, "onResponse: api: " + SharedPref.read(SharedPref.API_KEY, null));
                            SharedPref.write(SharedPref.ID, modelLogIn.getId());
                            //AppController.getInstance().setAPIkey(catObject.getString("appapikey"));



                        } catch (JSONException e)
                        {
                            Log.d(TAG, "onResponse: ERROR IN LOGIN JSON" + e.getMessage());
                            e.printStackTrace();
                        }

                    }
//

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "\nonResponse: JSON ERROR");
                error.printStackTrace();
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }



    public void setModelLogin(ModelLogIn modelLogin)
    {this.modelLogIn = modelLogin;}
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
