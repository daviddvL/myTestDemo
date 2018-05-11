package com.example.davidliu.demo.di.component;

import android.app.Activity;

import com.example.davidliu.demo.di.module.ActivityModule;
import com.example.davidliu.demo.di.scope.ActivityScope;
import com.example.davidliu.demo.ui.main.activity.MainActivity;
import com.example.davidliu.demo.ui.main.activity.WelcomeActivity;

import dagger.Component;

/**
 * Created by david.liu on 2018/5/3.
 */

@ActivityScope
@Component(dependencies = MyAppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(WelcomeActivity welcomeActivity);

    void inject(MainActivity mainActivity);

//    void inject(ZhihuDetailActivity zhihuDetailActivity);


}
