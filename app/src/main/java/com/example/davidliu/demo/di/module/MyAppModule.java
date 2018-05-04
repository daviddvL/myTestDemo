package com.example.davidliu.demo.di.module;

import com.example.davidliu.demo.app.MyApp;
import com.example.davidliu.demo.model.DataManager;
import com.example.davidliu.demo.model.db.DBHelper;
import com.example.davidliu.demo.model.http.HttpHelper;
import com.example.davidliu.demo.model.http.RetrofitHelper;
import com.example.davidliu.demo.model.sp.MySPHelper;
import com.example.davidliu.demo.model.sp.SpHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by david.liu on 2018/5/3.
 */

@Module
public class MyAppModule {

    private final MyApp application;

    public MyAppModule(MyApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApp provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, SpHelper preferencesHelper) {
        return new DataManager(httpHelper, preferencesHelper);
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

//    @Provides
//    @Singleton
//    DBHelper provideDBHelper(RealmHelper realmHelper) { //TODO : 数据库
//        return realmHelper;
//    }

    @Provides
    @Singleton
    SpHelper providePreferencesHelper(MySPHelper mySpHelper) {
        return mySpHelper;
    }
}
