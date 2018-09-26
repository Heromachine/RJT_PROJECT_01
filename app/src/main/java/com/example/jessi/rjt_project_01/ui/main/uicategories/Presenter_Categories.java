package com.example.jessi.rjt_project_01.ui.main.uicategories;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.rjt_project_01.AppController;
import com.example.jessi.rjt_project_01.data.models.ModelCategory;
import com.example.jessi.rjt_project_01.data.models.Model_Product;
import com.example.jessi.rjt_project_01.ui.main.uiproductlist.RecycleView_Adapter_Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Presenter_Categories implements IPresenter_Categories {

    IViewCategories iViewCategories;
    RecyclerView recyclerView;
    private RecycleView_Adapter_Product recycleViewAdapterProduct;
    private String productURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=ac56d9b1f49a843b9be57f8d2796ea35&user_id=1389";

    public Presenter_Categories(View_Categories mainActivity) {

        iViewCategories = new View_Categories();
        iViewCategories = mainActivity;
        iPresenter_VolleyItemRequest();
    }

    @Override
    public void iPresenter_VolleyItemRequest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                productURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray catagory = response.getJSONArray("category");

                            List <ModelCategory> modelCategoryList = new ArrayList<>();

                            for (int i = 0; i < catagory.length(); i++) {
                                JSONObject catObject = catagory.getJSONObject(i);

                                ModelCategory modelp = new ModelCategory();
                                //PLACE ALL ITEMS IN catObject into MODEL
                                modelp.setId(catObject.getString("cid"));
                                modelp.setName(catObject.getString("cname"));
                                modelp.setDescription(catObject.getString("cdiscription"));
                                modelp.setUrl(catObject.getString("cimagerl"));

                                //ADD MODEL(modelp) INTO A LIST

                                modelCategoryList.add(modelp);
                                iViewCategories.ViewGetCategoryList(modelCategoryList);
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
    }
    @Override
    public List<Model_Product> getListModel_Catelog(List categoryList) {
        return categoryList;
    }

    @Override
    public Model_Product getProduct() {
        return null;
    }
}
