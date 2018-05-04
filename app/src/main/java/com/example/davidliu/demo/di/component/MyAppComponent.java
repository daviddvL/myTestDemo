package com.example.davidliu.demo.di.component;

import com.example.davidliu.demo.app.MyApp;
import com.example.davidliu.demo.di.module.HttpModule;
import com.example.davidliu.demo.di.module.MyAppModule;
import com.example.davidliu.demo.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by david.liu on 2018/5/3.
 */

@Singleton
@Component(modules = {MyAppModule.class, HttpModule.class})
public interface MyAppComponent {

    MyApp getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    //TODO: MyApp 需要注入的依赖
//    RetrofitHelper retrofitHelper();  //提供http的帮助类
//
//    RealmHelper realmHelper();    //提供数据库帮助类
//
//    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
