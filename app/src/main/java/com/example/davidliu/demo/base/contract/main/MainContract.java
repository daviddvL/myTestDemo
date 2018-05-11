package com.example.davidliu.demo.base.contract.main;

import com.example.davidliu.demo.base.BasePresenter;
import com.example.davidliu.demo.base.BaseView;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * Created by david.liu on 2018/5/8.
 */

public interface MainContract {

    interface View extends BaseView{

        void showUpdateDialog(String versionContent);

        void startDownloadService();
    }

    interface Presenter extends BasePresenter<View>{

        void checkVersion(String currentVersion);

        void checkPermissions(RxPermissions rxPermissions);

//        void setNightModeState(boolean b);
//
        void setCurrentItem(int index);

        int getCurrentItem();
//
//        void setVersionPoint(boolean b);
//
//        boolean getVersionPoint();
    }
}
