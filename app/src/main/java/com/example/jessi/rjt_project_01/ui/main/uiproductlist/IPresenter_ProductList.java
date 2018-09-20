package com.example.jessi.rjt_project_01.ui.main.uiproductlist;

import android.content.Context;
import android.view.View;

public interface IPresenter_ProductList {

    public  void iPresenter_OnButtonClicked(View view, Context context);

    public void iPresenter_giveViewEditTextString(View view);

    public void iPresenter_VolleyItemRequest();
    public Model_Product getProduct();
}
