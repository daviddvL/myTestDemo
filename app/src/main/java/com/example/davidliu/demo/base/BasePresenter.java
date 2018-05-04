package com.example.davidliu.demo.base;

/**
 * Created by david.liu on 2018/5/2.
 *
 * Presenter基类
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
