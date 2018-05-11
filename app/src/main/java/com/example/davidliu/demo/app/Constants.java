package com.example.davidliu.demo.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by david.liu on 2018/5/2.
 */

public class Constants {

    //================= TYPE ====================
    public static final int TYPE_MM = 101; //
    public static final int TYPE_MEMORY = 102; //内部存储模块
    public static final int TYPE_SDCARD = 103; //SD卡模块
    public static final int TYPE_OTG = 104; //OTG模块
    public static final int TYPE_COLLECTION = 105; //收藏夹模块
    public static final int TYPE_SECRET = 106; //保密柜模块
    public static final int TYPE_SETTING = 107; //设置模块
    public static final int TYPE_ABOUT = 108; //关于模块


    //================= KEY ====================

    //    public static final String KEY_API = "f95283476506aa756559dd28a56f0c0b"; //需要APIKEY请去 http://apistore.baidu.com/ 申请,复用会减少访问可用次数
//    public static final String KEY_API = "52b7ec3471ac3bec6846577e79f20e4c"; //需要APIKEY请去 http://www.tianapi.com/#wxnew 申请,复用会减少访问可用次数
//
    public static final String BUGLY_ID = "863275c505";

    //================= PATH ====================
    public static final String PATH_DATA = MyApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    //网络缓存
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "david" + File.separator + "demo";


    //================= PREFERENCE ====================

    public static final String SP_NIGHT_MODE = "night_mode";
    public static final String SP_NO_IMAGE = "no_image";
    public static final String SP_CURRENT_ITEM = "current_item";


    //================= INTENT ====================

}
