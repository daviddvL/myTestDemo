package com.example.davidliu.demo.ui.main.fragment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.davidliu.demo.R;
import com.example.davidliu.demo.base.RootFragment;
import com.example.davidliu.demo.base.contract.mm.PictureContract;
import com.example.davidliu.demo.presenter.PicturePresenter;
import com.example.davidliu.demo.ui.main.activity.AboutActivity;
import com.example.davidliu.demo.utils.CircularAnimUtil;
import com.example.davidliu.demo.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by david.liu on 2018/5/9.
 */

public class PictureFragment extends RootFragment<PicturePresenter> implements PictureContract.View {

    @BindView(R.id.fbtn_pic)
    FloatingActionButton mFbtn;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.view_main)
    RecyclerView rvDailyList;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_picture;
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        //TODO : Adapter

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                if(currentDate.equals(DateUtil.getTomorrowDate())) {
//                    mPresenter.getDailyData();
//                } else {
//                    int year = Integer.valueOf(currentDate.substring(0,4));
//                    int month = Integer.valueOf(currentDate.substring(4,6));
//                    int day = Integer.valueOf(currentDate.substring(6,8));
//                    CalendarDay date = CalendarDay.from(year, month - 1, day);
//                    RxBus.getDefault().post(date);
//                }
                ToastUtil.shortShow("reload picture");
            }
        });
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        if (isDataReady) {
//            mPresenter.startInterval();
//        }
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        mPresenter.stopInterval();
//    }

    @OnClick(R.id.fbtn_pic)
    void onClickFbtn() {
        Intent it = new Intent();
        it.setClass(mContext,AboutActivity.class);
        CircularAnimUtil.startActivity(mActivity,it,mFbtn,R.color.fab_bg);
    }

}
