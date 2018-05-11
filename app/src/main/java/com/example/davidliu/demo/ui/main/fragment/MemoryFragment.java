package com.example.davidliu.demo.ui.main.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.davidliu.demo.R;
import com.example.davidliu.demo.base.SimpleFragment;
import com.example.davidliu.demo.ui.main.adapter.MemoryMainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by david.liu on 2018/5/9.
 */

public class MemoryFragment extends SimpleFragment {


    @BindView(R.id.tab_memory_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_memory_main)
    ViewPager mViewPager;

    String[] mTabTitle = new String[]{"图片","音乐","视频","文档","其他"};
    int[] mTabIcons = new int[]{R.mipmap.ic_drawer_wechat
                                ,R.mipmap.ic_drawer_wechat
                                ,R.mipmap.ic_drawer_wechat
                                ,R.mipmap.ic_drawer_wechat
                                ,R.mipmap.ic_drawer_wechat};
    List<Fragment> fragmentList = new ArrayList<Fragment>();

    MemoryMainAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_memory_main;
    }

    @Override
    protected void initEventAndData() {
        fragmentList.add(new PictureFragment());
        fragmentList.add(new MusicFragment());
        fragmentList.add(new VideoFragment());
        fragmentList.add(new DocumentFragment());
        fragmentList.add(new OtherTypeFragment());

        mAdapter = new MemoryMainAdapter(getChildFragmentManager(), fragmentList);
        mViewPager.setAdapter(mAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[3]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTabTitle[4]));
        mTabLayout.setupWithViewPager(mViewPager);

        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,重新setText
        for (int i = 0; i < mTabIcons.length; i++) {

            mTabLayout.getTabAt(i).setIcon(mTabIcons[i]).setText(mTabTitle[i]);
//            mTabLayout.getTabAt(i).setCustomView(mTabIcons[i]).setText(mTabTitle[i]);
            //设置选中和没选中的文字的颜色
            mTabLayout.setTabTextColors(Color.parseColor("#ff6b00"),Color.parseColor("#fffff9"));

        }
    }
}
