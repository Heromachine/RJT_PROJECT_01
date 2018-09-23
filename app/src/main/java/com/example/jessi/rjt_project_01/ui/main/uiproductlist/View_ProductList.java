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

public class View_ProductList extends AppCompatActivity implements IView_ProductList{

    private static final String TAG = "VIEW_MY_PRODUCT";

    IPresenter_ProductList iPresenter_productList;
    TextView ID;
    TextView Name;
    TextView Description;
    Model_Product mProd = new Model_Product();


    RecyclerView recyclerView;
    ListViewAdapter LVA;
    CustomProductlistAdapter CPA;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_productlist_recycleview);
        recyclerView = findViewById(R.id.rv_productlist_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        iPresenter_productList = new Presenter_ProductList(View_ProductList.this);
        LVA = new ListViewAdapter(View_ProductList.this, iPresenter_productList.getListModel_Product());

        recyclerView.setAdapter(LVA);


    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);
    }

    public void View_LogIn_clickHandler(View view)
    {
        iPresenter_productList.iPresenter_OnButtonClicked(view, this);
    }
}
