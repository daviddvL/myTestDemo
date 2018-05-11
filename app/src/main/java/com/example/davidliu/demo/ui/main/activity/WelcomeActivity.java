package com.example.davidliu.demo.ui.main.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.davidliu.demo.R;
import com.example.davidliu.demo.base.BaseActivity;
import com.example.davidliu.demo.base.contract.main.WelcomeContract;
import com.example.davidliu.demo.component.ImageLoader;
import com.example.davidliu.demo.model.bean.WelcomeBean;
import com.example.davidliu.demo.presenter.main.WelcomePresenter;
import com.example.davidliu.demo.utils.LogUtil;
import com.example.davidliu.demo.utils.ToastUtil;

import butterknife.BindView;

/**
 * Created by david.liu on 2018/5/2.
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View{

    @BindView(R.id.iv_welcome_bg)
    ImageView iv_welcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView tv_welcomeAuthor;

    @Override
    protected void initInject() {

        getActivityComponent().inject(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {

        ImageLoader.load(this, welcomeBean.getImg(), iv_welcomeBg);
        iv_welcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        tv_welcomeAuthor.setText(welcomeBean.getText());
        ToastUtil.show("-----"+welcomeBean.getText());
    }

    @Override
    public void jumpToMain() {

        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        Glide.clear(iv_welcomeBg);
        super.onDestroy();
    }

}
