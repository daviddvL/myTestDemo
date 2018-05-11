package com.example.davidliu.demo.base.contract.mm;

import com.example.davidliu.demo.base.BasePresenter;
import com.example.davidliu.demo.base.BaseView;

/**
 * Created by david.liu on 2018/5/9.
 */

public interface PictureContract {

    interface View extends BaseView {

        //todo :  提供 PicFragment 更新View需要的方法
//        void showContent(ThemeListBean themeListBean);



//        void showContent(DailyListBean info);
//
//        void showMoreContent(String date,DailyBeforeListBean info);
//
//        void doInterval(int currentCount);
    }

    interface Presenter extends BasePresenter<View> {


        //todo :  提供 picPresenter 需要的方法

        void getPicData();

//        void getDailyData();
//
//        void getBeforeData(String date);
//
//        void startInterval();
//
//        void stopInterval();
//
//        void insertReadToDB(int id);
    }
}
