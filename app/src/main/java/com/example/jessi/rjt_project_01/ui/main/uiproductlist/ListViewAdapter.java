package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.Model_Product;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Model_Product> {

    private List<Model_Product> productList;

    private Context CMtx;

    public ListViewAdapter(List<Model_Product> productList, Context mCtx) {
        super(mCtx, R.layout.fragment_product_list_item , productList);
    }
}
