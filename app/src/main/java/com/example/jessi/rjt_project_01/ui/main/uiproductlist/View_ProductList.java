package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;

public class View_ProductList extends AppCompatActivity implements IView_ProductList{

    private static final String TAG = "VIEW_MY_PRODUCT";

    IPresenter_ProductList iPresenter_productList;
    TextView ID;
    TextView Name;
    TextView Description;
    Model_Product mProd = new Model_Product();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_product_list);

        ID = findViewById(R.id.tv01);
        Name = findViewById(R.id.tv02);
        Description = findViewById(R.id.tv03);

        iPresenter_productList = new Presenter_ProductList(this);

        iPresenter_productList.iPresenter_VolleyItemRequest();


        mProd = iPresenter_productList.getProduct();

        ID.setText(mProd.getId());
        //ID.setText("POP");
//        Name.setText(mProd.getName());
//        Description.setText(mProd.getDescription());




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
