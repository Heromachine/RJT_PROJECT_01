package com.example.jessi.rjt_project_01.ui.main.uicategories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.ModelCategory;

import java.util.ArrayList;
import java.util.List;

public class View_Categories extends AppCompatActivity implements IViewCategories{

    IPresenter_Categories iPresenterCategories;
    RecyclerView recyclerView;
    RecyclerViewAdapterCategories recyclerViewAdapterCategories;
    private List<ModelCategory> modelCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_categorylist_recyclerview);
        modelCategoryList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv_categorylist_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        iPresenterCategories = new Presenter_Categories(View_Categories.this);
    }

    @Override
    public void ViewGetCategoryList(List catlist) {
        modelCategoryList = catlist;
        recyclerViewAdapterCategories = new RecyclerViewAdapterCategories(View_Categories.this, modelCategoryList);
        recyclerView.setAdapter(recyclerViewAdapterCategories);
    }
}
