package com.example.davidliu.demo.component;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.davidliu.demo.app.Constants;
import com.example.davidliu.demo.app.MyApp;
import com.example.davidliu.demo.utils.SystemUtil;
import com.example.davidliu.demo.widget.AppBlockCanaryContext;
import com.github.moduth.blockcanary.BlockCanary;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;


import static com.example.davidliu.demo.utils.LogUtil.isDebug;

/**
 * Created by david.liu on 2018/5/2.
 */

public class InitService extends IntentService {
    private static final String ACTION_INIT = "initApplication";

    public InitService() {
        super("Initservice");
    }

    public static void start(Context context){
        Intent intent = new Intent(context,InitService.class);
        intent.setAction(ACTION_INIT);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null){
            String action = intent.getAction();
            if (ACTION_INIT.equals(action)){
                initApplication();
            }
        }
    }

    private void initApplication() {

        //初始化日志信息
        Logger.init(getPackageName()).hideThreadInfo();

        //初始化Bugly
        initBugly();

        //初始化内存泄漏检测
        LeakCanary.install(MyApp.getInstance());

        //初始化绘制过度检测
        BlockCanary.install(getApplicationContext(),new AppBlockCanaryContext()).start();

        // TODO 初始化 x5 webView
//        QbSdk.allowThirdPartyAppDownload(true);
//        QbSdk.initX5Environment(getApplicationContext(), QbSdk.WebviewInitType.FIRSTUSE_AND_PRELOAD, new QbSdk.PreInitCallback() {
//            @Override
//            public void onCoreInitFinished() {
//            }
//
//            @Override
//            public void onViewInitFinished(boolean b) {
//            }
//        });

    }

    private void initBugly() {
        Context context = getApplicationContext();
        String packageName = context.getPackageName();
        String processName = SystemUtil.getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(context, Constants.BUGLY_ID, isDebug, strategy);
    }
}
