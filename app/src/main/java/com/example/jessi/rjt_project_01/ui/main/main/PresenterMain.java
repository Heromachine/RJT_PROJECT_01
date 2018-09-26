package com.example.jessi.rjt_project_01.ui.main.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.jessi.rjt_project_01.R;
import com.example.jessi.rjt_project_01.ui.main.uicategories.View_Categories;
import com.example.jessi.rjt_project_01.ui.main.uisignup.View_SignUp;

public class PresenterMain implements IPresenter {


    IMainActivity iMainActivity;

    public PresenterMain() {
    }

    public PresenterMain(MainActivity mainActivity) {
        iMainActivity = new MainActivity();
        iMainActivity = mainActivity;

    }

    @Override
    public void iPresenter_OnButtonClicked(View view, Context context) {
        switch (view.getId()) {
            case R.id.tv_viewallcat:
                Intent i = new Intent(context, View_Categories.class);
                context.startActivity(i);
                break;

        }
    }
}
