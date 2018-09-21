package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
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
import com.example.jessi.rjt_project_01.MySingleton;
import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.CustomProductlistAdapter;
import com.example.jessi.rjt_project_01.data.models.Model_Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Presenter_ProductList implements IPresenter_ProductList {
    private static final String TAG = "PRESENTERPRO";

    //STRING USED TO TEST IF DATA CAME FROM SERVER *NOT USEFUL
    String ID ;
    String Name;
    String Description;
    String ImageUrl;

    //RECYCLER
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;

    //VIEW RESOURCES
    private View_ProductList VPL;
    private IView_ProductList IVPL;
    private Context cntx;

    //TEM STRING FOR URL, MUST MAKE DYNAMIC LATER
    private String productURL = "http://rjtmobile.com/ansari/shopingcart/androidapp/cust_category.php?api_key=ac56d9b1f49a843b9be57f8d2796ea35&user_id=1389";

    //MODEL RESOURCES
    private Model_Product product;
    private ListView listView;
    private CustomProductlistAdapter CPLA;
    private List listModel_Product;

    //INIT THIS PRESENTER WITH
    public Presenter_ProductList(View_ProductList mainActivity)
    {
        VPL = mainActivity;
        IVPL = mainActivity;
        CPLA = new CustomProductlistAdapter(VPL, listModel_Product);
        listView = (ListView)  VPL.findViewById(R.id.tv_product_description );
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

        //REQUEST FROM ONLINE FIRST OBJECT(JSONOBJECT )
        final JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(
                Request.Method.GET,
                productURL,
                 null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //REQUEST AN ARRAY FROM THE FIRST JSON OBJECT(response) CALLED catagory
                            JSONArray catagory = response.getJSONArray("catagory");

                            //ITERATE THROUGH THE ARRAY catagory
                            for(int i = 0; i < catagory.length(); i++)
                            {
                                //CREATE JSON OBJECT (catObject) AND PLACE ONE OBJECT FROM catagory
                                JSONObject catObject = catagory.getJSONObject(i);

                                //CREATE MODEL(modelp)
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
                        // notifying list adapter about data changes so that it renders the list view with updated data
                        CPLA.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });




    }

    @Override
    public Model_Product getProduct() {
        return product;
    }
}
