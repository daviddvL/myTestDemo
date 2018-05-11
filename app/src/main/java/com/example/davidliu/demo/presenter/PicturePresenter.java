package com.example.davidliu.demo.presenter;

import com.example.davidliu.demo.base.RxPresenter;
import com.example.davidliu.demo.base.contract.mm.PictureContract;
import com.example.davidliu.demo.model.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by david.liu on 2018/5/9.
 */

public class PicturePresenter extends RxPresenter<PictureContract.View> implements PictureContract.Presenter{

    private DataManager mDataManager;
    private Disposable intervalSubscription;//TODO


    @Inject
    public PicturePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(PictureContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent() {
        //TODO :
    }

    @Override
    public void getPicData() {

    }
}
