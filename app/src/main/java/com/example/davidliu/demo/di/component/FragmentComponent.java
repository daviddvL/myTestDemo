package com.example.davidliu.demo.di.component;

import android.app.Activity;

import com.example.davidliu.demo.di.module.FragmentModule;
import com.example.davidliu.demo.di.scope.FragmentScope;
import com.example.davidliu.demo.ui.main.fragment.DocumentFragment;
import com.example.davidliu.demo.ui.main.fragment.MusicFragment;
import com.example.davidliu.demo.ui.main.fragment.OtherTypeFragment;
import com.example.davidliu.demo.ui.main.fragment.PictureFragment;
import com.example.davidliu.demo.ui.main.fragment.VideoFragment;

import dagger.Component;

/**
 * Created by david.liu on 2018/5/9.
 */

@FragmentScope
@Component(dependencies = MyAppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(PictureFragment picFragment);

    void inject(MusicFragment musicFragment);

    void inject(VideoFragment videoFragment);

    void inject(DocumentFragment docFragment);

    void inject(OtherTypeFragment otherTypeFragment);
}
