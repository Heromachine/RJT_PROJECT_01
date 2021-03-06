package com.example.jessi.rjt_project_01.di;

import com.example.jessi.rjt_project_01.ui.main.uilogin.ViewLoginMainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Component(modules = {ModuleModelCategory.class})
@Singleton
public interface MyComponent {
    //void injectViewLoginMainActivity(ViewLoginMainActivity viewLoginMainActivity);
    void inject(ViewLoginMainActivity viewLoginMainActivity);
}
