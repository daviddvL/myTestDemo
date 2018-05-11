package com.example.davidliu.demo.model.sp;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.davidliu.demo.app.Constants;
import com.example.davidliu.demo.app.MyApp;

import javax.inject.Inject;

/**
 * Created by david.liu on 2018/5/3.
 */

public class MySPHelper implements SpHelper {

    private static final boolean DEFAULT_NIGHT_MODE = false;
    private static final boolean DEFAULT_NO_IMAGE = false;
    private static final boolean DEFAULT_AUTO_SAVE = true;

    private static final boolean DEFAULT_LIKE_POINT = false;
    private static final boolean DEFAULT_VERSION_POINT = false;
    private static final boolean DEFAULT_MANAGER_POINT = false;

    private static final int DEFAULT_CURRENT_ITEM = Constants.TYPE_MM;//默认显示的模块ID

    private static final String SHAREDPREFERENCES_NAME = "my_sp";

    private final SharedPreferences  mSPrefs;

    @Inject
    public MySPHelper() {
        mSPrefs = MyApp.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public int getCurrentItem() {
        return mSPrefs.getInt(Constants.SP_CURRENT_ITEM, DEFAULT_CURRENT_ITEM);
    }

    @Override
    public void setCurrentItem(int item) {
        mSPrefs.edit().putInt(Constants.SP_CURRENT_ITEM, item).apply();
    }
}
