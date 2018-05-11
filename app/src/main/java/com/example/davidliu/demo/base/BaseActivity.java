package com.example.davidliu.demo.base;

import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import com.example.davidliu.demo.app.MyApp;
import com.example.davidliu.demo.di.component.ActivityComponent;
import com.example.davidliu.demo.di.component.DaggerActivityComponent;
import com.example.davidliu.demo.di.module.ActivityModule;
import com.example.davidliu.demo.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by david.liu on 2018/5/2.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView{


    @Inject
    protected T mPresenter;


    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .myAppComponent(MyApp.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }


    @Override
    protected void onViewCreated() {
        super.onViewCreated();

        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    protected abstract void initInject();
}
