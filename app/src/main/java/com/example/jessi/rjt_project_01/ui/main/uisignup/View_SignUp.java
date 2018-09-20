package com.example.jessi.rjt_project_01.ui.main.uisignup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;

public class View_SignUp extends AppCompatActivity implements IView_SignUp {

    Presenter_SignUp iPresenter;
    TextView instructionsError;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
    }

    @Override
    public void vis_getUserName(View view) {

    }

    @Override
    public void vis_getPassword(View view) {

    }

    @Override
    public void vis_getPassword2(View view) {

    }

    @Override
    public void vis_getEmail(View view) {

    }

    @Override
    public void vis_setInstructions(View view) {

    }
}
