package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.CustomProductlistAdapter;
import com.example.jessi.rjt_project_01.data.models.Model_Product;

import java.util.ArrayList;
import java.util.List;

public class ViewMainActivityProductList extends AppCompatActivity implements IViewProductList {

    private static final String TAG = "VIEW_MY_PRODUCT";

    IPresenterProductList iPresenter_productList;
    RecyclerView recyclerView;
    RecycleView_Adapter_Product recyclerViewAdapterProduct;
    private List<Model_Product> listModel_Product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_productlist_recycleview);
        listModel_Product = new ArrayList<>();
        recyclerView = findViewById(R.id.rv_productlist_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        iPresenter_productList = new Presenter_ProductList(ViewMainActivityProductList.this);
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        Log.d(TAG, "onCreateView: ");
        return super.onCreateView(parent, name, context, attrs);
    }

    public void view_LogIn_clickHandler(View view)
    {
        Log.d(TAG, "View_LogIn_clickHandler: ");
        iPresenter_productList.iPresenter_OnButtonClicked(view, this);
    }

    @Override
    public void ViewGetProductList(List Plist)
    {
        listModel_Product = Plist;
        recyclerViewAdapterProduct = new RecycleView_Adapter_Product(ViewMainActivityProductList.this, listModel_Product);
        recyclerView.setAdapter(recyclerViewAdapterProduct);
    }
}
