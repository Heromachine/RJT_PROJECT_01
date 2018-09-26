package com.example.jessi.rjt_project_01.ui.main.uisignup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jessi.rjt_project_01.R;

public class View_SignUp extends AppCompatActivity implements IView_SignUp {

    IPresenter_SignUp iPresenterSignUp;
    TextView instructionsError;

    EditText firstname;
    EditText lastname;
    EditText address;
    EditText password;
    EditText email;
    EditText mobile;

    Button btnLogin;
    Button btnRegister;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_signup);

        iPresenterSignUp = new Presenter_SignUp(this);
        firstname = findViewById(R.id.etx_su_firstname);
        lastname  = findViewById(R.id.etx_su_lastname);
        address   = findViewById(R.id.etx_su_address);
        password  = findViewById(R.id.etx_su_password);
        email     = findViewById(R.id.etx_su_email);
        mobile    = findViewById(R.id.etx_su_mobile);

        btnLogin = findViewById(R.id.btn_su_login);
        btnRegister = findViewById(R.id.btn_su_register);
    }

    public void View_SignUp_clickHandler(View view)
    {
        iPresenterSignUp.iPresenter_OnButtonClicked(
                view,
                this,
                firstname.getText().toString(),
                lastname.getText().toString(),
                address.getText().toString(),
                password.getText().toString(),
                email.getText().toString(),
                mobile.getText().toString());
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
