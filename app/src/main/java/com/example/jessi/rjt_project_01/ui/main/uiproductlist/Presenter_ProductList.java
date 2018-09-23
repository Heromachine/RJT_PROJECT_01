package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.graphics.ColorSpace;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.jessi.rjt_project_01.AppController;
import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.CustomProductlistAdapter;
import com.example.jessi.rjt_project_01.data.models.Model_Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Presenter_ProductList implements IPresenter_ProductList {
    private static final String TAG = "PRESENTERPRO";

    //VIEW RESOURCES
    private View_ProductList VPL;

    //TEM STRING FOR URL, MUST MAKE DYNAMIC LATER
    private String productURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=ac56d9b1f49a843b9be57f8d2796ea35&user_id=1389";

    private String ossomURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=5fcb3d85f0ce5afb02618973b9e17919&user_id=1385";
     /////////////////////////////////////
    RecyclerView recyclerView;
    private CustomProductlistAdapter CPLA;
    private ListViewAdapter LVA;
    private List <Model_Product> listModel_Product;
    ///////////////////////////////////////

    //INIT THIS PRESENTER WITH----------------------------------------------------------------------
    public Presenter_ProductList(View_ProductList mainActivity)
    {
        Log.d(TAG, "iPresenter_VolleyItemRequest: ===================================================");
        listModel_Product = new ArrayList<>();
        iPresenter_VolleyItemRequest();
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
                Request.Method.GET,
                ossomURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray catagory = response.getJSONArray("category");

                            for (int i = 0; i < catagory.length(); i++) {
                                JSONObject catObject = catagory.getJSONObject(i);

                                Model_Product modelp = new Model_Product();
                                //PLACE ALL ITEMS IN catObject into MODEL
                                modelp.setId(catObject.getString("cid"));
                                modelp.setName(catObject.getString("cname"));
                                modelp.setDescription(catObject.getString("cdiscription"));
                                modelp.setUrl(catObject.getString("cimagerl"));

                                //ADD MODEL(modelp) INTO A LIST
                                listModel_Product.add(modelp);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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
    public List<Model_Product> getListModel_Product()
    {
        return listModel_Product;
    }
    @Override
    public Model_Product getProduct() {
        return null;
    }




}
