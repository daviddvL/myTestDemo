package com.example.davidliu.demo.model;

import com.example.davidliu.demo.model.bean.WelcomeBean;
import com.example.davidliu.demo.model.db.DBHelper;
import com.example.davidliu.demo.model.http.HttpHelper;
import com.example.davidliu.demo.model.sp.SpHelper;

import io.reactivex.Flowable;

/**
 * Created by david.liu on 2018/5/2.
 *
 *  所有数据的管理类
 */

public class DataManager implements HttpHelper,SpHelper{

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    SpHelper mSpHelper;


//    public DataManager(HttpHelper mHttpHelper, DBHelper mDbHelper, SpHelper mSpHelper) {
//        this.mHttpHelper = mHttpHelper;
//        this.mDbHelper = mDbHelper;
//        this.mSpHelper = mSpHelper;
//    }

    //TODO : 未集成数据库，构造方法中加入DBHelper，并在appModule,提供注入的依赖实例
    public DataManager(HttpHelper mHttpHelper,SpHelper mSpHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mSpHelper = mSpHelper;
    }

    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mHttpHelper.fetchWelcomeInfo(res);
    }


    @Override
    public int getCurrentItem() {
        return mSpHelper.getCurrentItem();
    }

    @Override
    public void setCurrentItem(int item) {
        mSpHelper.setCurrentItem(item);
    }
}
