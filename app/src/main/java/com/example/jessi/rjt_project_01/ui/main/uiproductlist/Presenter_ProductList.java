package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.rjt_project_01.AppController;
import com.example.jessi.rjt_project_01.data.models.Model_Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Presenter_ProductList implements IPresenterProductList {
    private static final String TAG = "PRESENTERPRO";

    //VIEW RESOURCES
    private IViewProductList iViewMainActivityProductList;

    //TEM STRING FOR URL, MUST MAKE DYNAMIC LATER
    private String productURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=ac56d9b1f49a843b9be57f8d2796ea35&user_id=1389";

    private String ossomURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=5fcb3d85f0ce5afb02618973b9e17919&user_id=1385";
     /////////////////////////////////////
    RecyclerView recyclerView;
    private RecycleView_Adapter_Product recycleViewAdapterProduct;

    ///////////////////////////////////////

    //INIT THIS PRESENTER WITH----------------------------------------------------------------------
    public Presenter_ProductList(ViewMainActivityProductList mainActivity)
    {
        iViewMainActivityProductList = new ViewMainActivityProductList();
        iViewMainActivityProductList = mainActivity;
        iPresenter_VolleyItemRequest();
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

                            List <Model_Product> listModel_Product = new ArrayList<>();

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
                                iViewMainActivityProductList.ViewGetProductList(listModel_Product);
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
    public void iPresenter_OnButtonClicked(View view, Context context) {

    }

    @Override
    public void iPresenter_giveViewEditTextString(View view) {
        Log.d(TAG, "iPresenter_giveViewEditTextString: ");
    }

    @Override
    public List<Model_Product> getListModel_Product( List productList)
    {
        return productList;
    }
    @Override
    public Model_Product getProduct() {
        return null;
    }

    public List<Model_Product> returnListModel_Product(){
        return null;
    }




}
