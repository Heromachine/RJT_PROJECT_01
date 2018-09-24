package com.example.jessi.rjt_project_01.ui.main.uilogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jessi.rjt_project_01.R;

public class View_Login extends AppCompatActivity implements IView_Login {

    IPresenter_Login iPresenter;
    EditText etPhone;
    EditText etPassWord;

    Button btnLogin;
    Button btnSinup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        iPresenter = new Presenter_Login(this);

        etPhone = findViewById(R.id.et_li_phone);
        etPassWord = findViewById(R.id.et_li_password);

        btnLogin = findViewById(R.id.btn_li_login);
        btnSinup = findViewById(R.id.btn_li_go_to_signup);
       etPhone.setText(iPresenter.returnUsername());
       etPassWord.setText(iPresenter.returnPassword());





    }

    public void View_LogIn_clickHandler(View view)
    {
        iPresenter.iPresenter_OnButtonClicked(view, this, etPhone.getText().toString(), etPassWord.getText().toString());
    }


    @Override
    public void vil_getUsername(View view) {

    }

    @Override
    public void vil_setUsername(View view) {

    }
}
