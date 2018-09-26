package com.example.jessi.rjt_project_01.ui.main.uilogin;

import android.view.View;

import com.example.jessi.rjt_project_01.data.models.ModelCategory;

public interface IViewLogin {
    void getModel(ModelCategory ModCat);

    public void getUsername(View view );
    public void giveUsername(View view);

    public void getPhone(View view);
    public void setPhone(View view);


}
