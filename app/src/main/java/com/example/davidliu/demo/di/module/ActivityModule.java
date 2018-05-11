package com.example.davidliu.demo.di.module;

import android.app.Activity;

import com.example.davidliu.demo.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david.liu on 2018/5/3.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
