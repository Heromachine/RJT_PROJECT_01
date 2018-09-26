package com.example.jessi.rjt_project_01.ui.main.uisignup;

import android.content.Context;
import android.view.View;



public interface IPresenter_SignUp {

    public void iPresenter_OnButtonClicked(View view, Context context, String fname, String lname, String address, String password, String email, String mobile);
}
