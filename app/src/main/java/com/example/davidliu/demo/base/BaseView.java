package com.example.davidliu.demo.base;

/**
 * Created by david.liu on 2018/5/2.
 *
 * View基类
 */

public interface BaseView {

    void showErrorMsg(String msg);

    void useNightMode(boolean isNight);

    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
