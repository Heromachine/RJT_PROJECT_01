package com.example.jessi.rjt_project_01.ui.main.uisignup;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.data.localdata.ModelValidation;
import com.example.jessi.rjt_project_01.data.models.ModelSignUp;

import java.util.ArrayList;

public class Presenter_SignUp implements IPresenter_SignUp {
    private static final String TAG = "Presenter_SignUp";
    private IView_SignUp iViewSignUp;
    private ModelValidation modelValidation;
    private ModelSignUp modelSignUp;

    private String error;

    private String fname;
    private String lname;
    private String address;
    private String password;
    private String email;
    private String mobile;

    private final ArrayList<String> SIGNINPATTERNS = new ArrayList<String>();
    private final ArrayList<String> SIGNINFEILDNAMES = new ArrayList<String>();

    public Presenter_SignUp(View_SignUp mainActivity)
    {
        iViewSignUp = new View_SignUp();
        iViewSignUp = mainActivity;

        SIGNINPATTERNS.add ("^[ A-Za-z]{3,15}$"); //FirstName
        SIGNINPATTERNS.add ("^[A-Za-z0-9]{6,18}$"); //LastName
        SIGNINPATTERNS.add ("^[A-Za-z0-9]{6,18}$");//address
        SIGNINPATTERNS.add("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");//password
        SIGNINPATTERNS.add ("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"); //email
        SIGNINPATTERNS.add ("^(\\d{3}?\\d{3}?\\d{4})$");

        SIGNINFEILDNAMES.add("First Name: ");
        SIGNINFEILDNAMES.add("Last Name: ");
        SIGNINFEILDNAMES.add("Address: ");
        SIGNINFEILDNAMES.add("Password: ");
        SIGNINFEILDNAMES.add("Email: ");
        SIGNINFEILDNAMES.add("Mobile Phone: ");

        this.modelValidation = new ModelValidation(SIGNINPATTERNS, SIGNINFEILDNAMES);

    }


    @Override
    public void iPresenter_OnButtonClicked(View view, Context context, String fname, String lname, String address, String password, String email, String mobile)
    {
      this.fname = fname;
      this.lname = lname;
      this.address = address;
      this.password = password;
      this.email = email;
      this.mobile = mobile;


        switch(view.getId())
        {
            case R.id.btn_su_register:

                this.modelValidation.addTextViewString(this.fname);
                this.modelValidation.addTextViewString(this.lname);
                this.modelValidation.addTextViewString(this.address);
                this.modelValidation.addTextViewString(this.password);
                this.modelValidation.addTextViewString(this.email);
                this.modelValidation.addTextViewString(this.mobile);
                boolean temp = modelValidation.validation();

                if (!temp)
                {
                    Toast.makeText(context, "Invalid Form", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context, "Registration Succesful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, View_SignUp.class);
                    context.startActivity(i);

                }
                break;
            case R.id.btn_su_login:
                Intent i = new Intent(context, View_SignUp.class);
                context.startActivity(i);
                break;
        }

    }
}
