package com.example.davidliu.demo.presenter.main;

import com.example.davidliu.demo.base.RxPresenter;
import com.example.davidliu.demo.base.contract.main.WelcomeContract;
import com.example.davidliu.demo.model.DataManager;
import com.example.davidliu.demo.model.bean.WelcomeBean;
import com.example.davidliu.demo.utils.LogUtil;
import com.example.davidliu.demo.utils.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;


/**
 * Created by david.liu on 2018/5/2.
 */

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {


    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private DataManager mDataManager;

    @Inject
    public WelcomePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getWelcomeData() {
        addSubscribe(mDataManager.fetchWelcomeInfo(RES)
                .compose(RxUtil.<WelcomeBean>rxSchedulerHelper())
                .subscribe(new Consumer<WelcomeBean>() {
                    @Override
                    public void accept(WelcomeBean welcomeBean) {
                        mView.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.jumpToMain();
                    }
                })
        );
    }

    public void startCountDown() {
        addSubscribe(Flowable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        mView.jumpToMain();
                    }
                })
        );
    }



}
