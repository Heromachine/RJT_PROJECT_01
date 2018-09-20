package com.example.jessi.rjt_project_01.ui.main.uilogin;

import android.content.Context;
import android.view.View;

public interface IPresenter_Login {

    public  void iPresenter_OnButtonClicked(View view, Context context, String username, String password);
    public String returnUsername();
    public String returnPassword();
    public void setUserName(String username);
    public void setPassWord(String password);
    public void iPresenter_giveViewEditTextString(View view);
}
