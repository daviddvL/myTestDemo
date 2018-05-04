package com.example.davidliu.demo.model.http;

import com.example.davidliu.demo.model.bean.WelcomeBean;
import com.example.davidliu.demo.model.http.api.ZhihuApis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by david.liu on 2018/5/3.
 */

public class RetrofitHelper implements HttpHelper {

    private ZhihuApis mZhihuApiService;
//    private GankApis mGankApiService;
//    private WeChatApis mWechatApiService;
//    private MyApis mMyApiService;
//    private GoldApis mGoldApiService;
//    private VtexApis mVtexApiService;

    //TODO :各个模块的API
    @Inject
    public RetrofitHelper(ZhihuApis zhihuApiService) {
        this.mZhihuApiService = zhihuApiService;
//        this.mGankApiService = gankApiService;
//        this.mWechatApiService = wechatApiService;
//        this.mMyApiService = myApiService;
//        this.mGoldApiService = goldApiService;
//        this.mVtexApiService = vtexApiService;
    }


    @Override
    public Flowable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhihuApiService.getWelcomeInfo(res);
    }
}
