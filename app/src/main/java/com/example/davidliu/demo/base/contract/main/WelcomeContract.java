package com.example.davidliu.demo.base.contract.main;

import com.example.davidliu.demo.base.BasePresenter;
import com.example.davidliu.demo.base.BaseView;
import com.example.davidliu.demo.model.bean.WelcomeBean;

/**
 * Created by david.liu on 2018/5/2.
 */

public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(WelcomeBean welcomeBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getWelcomeData();

    }
}
