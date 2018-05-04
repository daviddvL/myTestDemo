package com.example.davidliu.demo.model.http;

import com.example.davidliu.demo.model.bean.WelcomeBean;

import io.reactivex.Flowable;

/**
 * Created by david.liu on 2018/5/2.
 */

public interface HttpHelper {

//    TODO：HttpHelper

    Flowable<WelcomeBean> fetchWelcomeInfo(String res);
}
