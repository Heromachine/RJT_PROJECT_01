package com.example.jessi.rjt_project_01.ui.main.uicategories;

import android.content.Context;
import android.view.View;

import com.example.jessi.rjt_project_01.data.models.Model_Product;

import java.util.List;

public interface IPresenter_Categories {

    public  void iPresenter_OnButtonClicked(View view, Context context);

    public void iPresenter_giveViewEditTextString(View view);

    public void iPresenter_VolleyItemRequest();

    List<Model_Product> getListModel_Catelog(List productList);

    public Model_Product getProduct();

}
