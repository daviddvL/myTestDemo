package com.example.davidliu.demo.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.example.davidliu.demo.component.InitService;

import java.util.HashSet;
import java.util.Set;

//import sun.security.krb5.Realm;

/**
 * Created by david.liu on 2018/5/2.
 */

public class MyApp extends Application {

    private static MyApp instance;
    private Set<Activity> allActivities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    public static synchronized MyApp getInstance() {
        return instance;
    }

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //初始化屏幕宽高
        getScreenSize();

        //TODO:初始化数据库
//        Realm.init(getApplicationContext());

        //在子线程中完成其他初始化
        InitService.start(this);


    }


    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //TODO MultiDex
//        MultiDex.install(this);
    }

    //添加act到管理器
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    //移除act
    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    //安全退出应用
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


    public void getScreenSize() {
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    //TODO Dagger2 依赖注入
//    public static AppComponent getAppComponent(){
//        if (appComponent == null) {
//            appComponent = DaggerAppComponent.builder()
//                    .appModule(new AppModule(instance))
//                    .httpModule(new HttpModule())
//                    .build();
//        }
//        return appComponent;
//    }
}
