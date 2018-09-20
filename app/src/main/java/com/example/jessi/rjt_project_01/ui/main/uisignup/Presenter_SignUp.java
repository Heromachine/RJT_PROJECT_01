package com.example.jessi.rjt_project_01.ui.main.uisignup;

import android.view.View;

import com.example.jessi.rjt_project_01.data.localdata.Model_Validation;

import java.util.ArrayList;

public class Presenter_SignUp implements IPresenter_SignUp {

    IView_SignUp VIS;
    Model_Validation MVS;

    String error;

    private final ArrayList<String> SIGNINPATTERNS = new ArrayList<String>();
    private final ArrayList<String> SIGNINFEILDNAMES = new ArrayList<String>();

    @Override
    public void iPresenter_OnButtonClicked(View view) {

    }
}
