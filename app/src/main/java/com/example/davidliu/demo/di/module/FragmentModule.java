package com.example.davidliu.demo.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.davidliu.demo.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david.liu on 2018/5/9.
 */

@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
