package com.example.jessi.rjt_project_01.di;

import android.content.Context;
import android.view.View;

import com.example.jessi.rjt_project_01.data.models.ModelCategory;
import com.example.jessi.rjt_project_01.ui.main.uilogin.IViewLogin;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleModelCategory {

    Context context;
    public ModuleModelCategory(Context context)
    {
        this.context = context;
    }

    @Provides
    public Context getContext()
    {
        return context;
    }



    @Provides
    ModelCategory providesModelCategoryObject()
    {
        return new ModelCategory();
    }
//    @Provides
//    //ViewLoginMainActivity viewLoginMainActivity
//    public IViewLogin giveViewLogin(){
//
//        return new IViewLogin() {
//            @Override
//            public void getModel(ModelCategory ModCat) {
//
//            }
//
//            @Override
//            public void getUsername(View view) {
//
//            }
//
//            @Override
//            public void giveUsername(View view) {
//
//            }
//
//            @Override
//            public void getPhone(View view) {
//
//            }
//
//            @Override
//            public void setPhone(View view) {
//
//            }
//        };
//    }
}
