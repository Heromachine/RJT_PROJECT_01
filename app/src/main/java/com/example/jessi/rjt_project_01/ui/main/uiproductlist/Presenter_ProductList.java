package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.rjt_project_01.MainActivity;
import com.example.jessi.rjt_project_01.MySingleton;
import com.example.jessi.rjt_project_01.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Presenter_ProductList implements IPresenter_ProductList {
    private static final String TAG = "PRESENTERPRO";
    
    

    View_ProductList VPL;
    IView_ProductList IVPL;
    Context cntx;

    String productURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=c56d9b1f49a843b9be57f8d2796ea35&user_id=1389";

    String ID ;
    String Name;
    String Description;
    String ImageUrl;

    Model_Product product;

    public Presenter_ProductList(View_ProductList mainActivity)
    {
        VPL = mainActivity;
        IVPL = mainActivity;

    }

    @Override
    public void iPresenter_OnButtonClicked(View view, Context context) {
        switch(view.getId()) {
        }
    }

    @Override
    public void iPresenter_giveViewEditTextString(View view) {
    }





    @Override
    public void iPresenter_VolleyItemRequest() {
        Log.d(TAG, "iPresenter_VolleyItemRequest: ");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                productURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Log.d(TAG, "onResponse: =====================================================ID");
                            ID =  response.getString("cid");
                            Log.d(TAG, "onResponse: =====================================================ID"+ID);
                            Name =  response.getString("cname");
                            Description =  response.getString("cdiscription");
                            ImageUrl =  response.getString("cimagerl");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        product = new Model_Product(ID, Name, Description, ImageUrl);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VPL, "COULD NOT LOAD", Toast.LENGTH_LONG).show();
                error.printStackTrace();

            }
        });
        MySingleton.getInstance(VPL).addToRequestQueue(jsonObjectRequest);
        {

        }
    }

    @Override
    public Model_Product getProduct() {
        return product;
    }


}
