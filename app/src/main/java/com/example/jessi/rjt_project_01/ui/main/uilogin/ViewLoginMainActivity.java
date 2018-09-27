package com.example.jessi.rjt_project_01.ui.main.uilogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.models.ModelCategory;


import com.example.jessi.rjt_project_01.di.DaggerMyComponent;
import com.example.jessi.rjt_project_01.di.ModuleModelCategory;
import com.example.jessi.rjt_project_01.di.MyComponent;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;

public class ViewLoginMainActivity extends AppCompatActivity implements IViewLogin {

    IPresenter_Login iPresenter;
    EditText etPhone;
    EditText etPassWord;

    Button btnLogin;
    Button btnSinup;

    String logInError;

    ModelCategory modelCategory;
//     @Inject
//     ModuleModelCategory moduleModelCategory;
//     MyComponent myComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        iPresenter = new PresenterLogin(this);

        modelCategory = new ModelCategory();

//        myComponent = DaggerMyComponent.builder().moduleModelCategory(moduleModelCategory).build();
//        //myComponent = DaggerMyComponent.builder().moduleModelCategory(new ModuleModelCategory(this)).build();
//        myComponent.inject(this);

        etPhone = findViewById(R.id.et_li_phone);
        etPassWord = findViewById(R.id.et_li_password);
        btnLogin = findViewById(R.id.btn_li_login);
        btnSinup = findViewById(R.id.btn_li_go_to_signup);

       etPhone.setText(iPresenter.returnUsername());
       etPassWord.setText(iPresenter.returnPassword());
    }


    @Override
    public void getModel(ModelCategory ModCat)
    {
        modelCategory = ModCat;
//       // moduleModelCategory = ModCat;
//        myComponent = (MyComponent) ModCat;


    }
    public void View_LogIn_clickHandler(View view)
    {
        iPresenter.iPresenter_OnButtonClicked(view, this, etPhone.getText().toString(), etPassWord.getText().toString());


    }


    @Override
    public void getUsername(View view) {

    }

    @Override
    public void giveUsername(View view) {

    }

    @Override
    public void getPhone(View view) {

    }

    @Override
    public void setPhone(View view) {

    }
}
