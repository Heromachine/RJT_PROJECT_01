package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;

public class ProductListItemFragment extends Fragment {

    TextView itemDetails;

    @Nullable
    @Override
    public View onCreateView
            (@NonNull LayoutInflater inflater,
             @Nullable ViewGroup container,
             @Nullable Bundle savedInstanceState)
    {
       View v = inflater.inflate(R.layout.fragment_product_list_item, container, false);
       return v;
    }
}
