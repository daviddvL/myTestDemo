package com.example.davidliu.demo.ui.main.activity;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.example.davidliu.demo.R;
import com.example.davidliu.demo.app.Constants;
import com.example.davidliu.demo.app.MyApp;
import com.example.davidliu.demo.base.BaseActivity;
import com.example.davidliu.demo.base.contract.main.MainContract;
import com.example.davidliu.demo.presenter.main.MainPresenter;
import com.example.davidliu.demo.ui.main.fragment.MemoryFragment;
import com.example.davidliu.demo.utils.ToastUtil;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.lang.reflect.Method;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    NavigationView mNavigationView;
    @BindView(R.id.view_search)
    MaterialSearchView mSearchView;

    MemoryFragment mMemoryFragment;

    MenuItem mLastMenuItem;
    MenuItem mSearchMenuItem;
    ActionBarDrawerToggle mDrawerToggle;

    private int hideFragment = Constants.TYPE_MEMORY;//TODO: mm模块Type
    private int mShowFragment = Constants.TYPE_MEMORY;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShowFragment = mPresenter.getCurrentItem();
        hideFragment = Constants.TYPE_MM;
        showHideFragment(getTargetFragment(mShowFragment), getTargetFragment(hideFragment));
        mNavigationView.getMenu().findItem(R.id.menu_item_mm).setChecked(false);
        mToolbar.setTitle(mNavigationView.getMenu().findItem(getCurrentItem(mShowFragment)).getTitle().toString());
        hideFragment = mShowFragment;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar,"我的MM");
        mToolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        mToolbar.inflateMenu(R.menu.activity_tool_bar);//设置右上角的填充菜单
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_sort_way:
                        ToastUtil.shortShow("排序方式");
                        break;
                    case R.id.action_sort_order:
                        ToastUtil.shortShow("排序顺序");
                        break;
                    case R.id.action_options:
                        ToastUtil.shortShow("查看选项");
                        break;
                        case R.id.action_operation:
                        ToastUtil.shortShow("文件操作");
                        break;
                }
                return true;
            }
        });

        mMemoryFragment = new MemoryFragment();
        //TODO : other fragment

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mLastMenuItem = mNavigationView.getMenu().findItem(R.id.menu_item_mm);
        loadMultipleRootFragment(R.id.fl_main_container,0,mMemoryFragment);//todo:.mOtherfagment

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_item_mm:
                        mShowFragment = Constants.TYPE_MEMORY;
                        mSearchMenuItem.setVisible(false);
                        break;
                    case R.id.menu_item_memory:
                        mShowFragment = Constants.TYPE_MEMORY;
                        mSearchMenuItem.setVisible(true);
                        break;
                    case R.id.menu_item_sdcard:
                        mShowFragment = Constants.TYPE_SDCARD;
                        mSearchMenuItem.setVisible(true);
                        break;
                    case R.id.menu_item_collection:
                        mShowFragment = Constants.TYPE_COLLECTION;
                        mSearchMenuItem.setVisible(true);
                        break;
                    case R.id.menu_item_secret:
                        mShowFragment = Constants.TYPE_SECRET;
                        mSearchMenuItem.setVisible(true);
                        break;
                    case R.id.menu_item_setting:
                        ToastUtil.shortShow("设置");
                        break;
                    case R.id.menu_item_about:
                        ToastUtil.shortShow("关于");
                        break;
                }
                if(mLastMenuItem != null) {
                    mLastMenuItem.setChecked(false);
                }
                mLastMenuItem = item;
                mPresenter.setCurrentItem(mShowFragment);
                item.setChecked(true);
                mToolbar.setTitle(item.getTitle());
                mDrawerLayout.closeDrawers();
                showHideFragment(getTargetFragment(mShowFragment), getTargetFragment(hideFragment));
                hideFragment = mShowFragment;
                return true;
            }
        });

        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void showUpdateDialog(String versionContent) {

    }

    //下载新版本
    @Override
    public void startDownloadService() {

    }

    public void onBackPressedSupport() {
//        if (mSearchView.isSearchOpen()) {
//            mSearchView.closeSearch();
//        } else {
            showExitDialog();
//        }
    }

    private void showExitDialog() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确定退出吗");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyApp.getInstance().exitApp();
            }
        });
        builder.show();
    }

    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Constants.TYPE_MM:
                return mMemoryFragment;
            case Constants.TYPE_MEMORY:
                return mMemoryFragment;
            case Constants.TYPE_SDCARD:
                return mMemoryFragment;
            case Constants.TYPE_OTG:
                return mMemoryFragment;
            case Constants.TYPE_COLLECTION:
                return mMemoryFragment;
            case Constants.TYPE_SECRET:
                return mMemoryFragment;
            case Constants.TYPE_SETTING:
                return mMemoryFragment;
            case Constants.TYPE_ABOUT:
                return mMemoryFragment;
        }
        return mMemoryFragment;
    }

    private int getCurrentItem(int item) {
        switch (item) {
            case Constants.TYPE_MM:
                return R.id.menu_item_mm;
            case Constants.TYPE_MEMORY:
                return R.id.menu_item_memory;
            case Constants.TYPE_SDCARD:
                return R.id.menu_item_sdcard;
            case Constants.TYPE_OTG:
                return R.id.menu_item_otg;
            case Constants.TYPE_COLLECTION:
                return R.id.menu_item_otg;
            case Constants.TYPE_SECRET:
                return R.id.menu_item_secret;
            case Constants.TYPE_SETTING:
                return R.id.menu_item_setting;
            case Constants.TYPE_ABOUT:
                return R.id.menu_item_about;
        }
        return R.id.menu_item_memory;
    }

    /**
     **显示溢出菜单图标
     **/
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        mSearchView.setMenuItem(item);
        mSearchMenuItem = item;
        return true;
    }



}
